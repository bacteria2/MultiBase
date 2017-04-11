package com.multi.auth.shiro.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.multi.auth.shiro.EncryptionUtil;
import com.multi.auth.shiro.service.IUserService;
import com.multi.common.util.DateTimeUtil;
import com.multi.data.relationdb.Status;
import com.multi.data.relationdb.user.MUser;
import com.multi.data.relationdb.user.dao.MUserMapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description 用户查询修改禁用等功能
 */
@Service
public class UserServiceImpl implements IUserService {

    private Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    MUserMapper userMapper;


    @Override
    public int insertNewUser(MUser user,String creator) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getUsername()),"username不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getPassword()),"password不能为空");
        log.info("新增一条用户记录,用户名%s",user.getUsername());
        user.setCreator(creator);
        user.setModifier(creator);
        return userMapper.insertSelective(  EncryptionUtil.md5Password(user));
    }

    @Override
    public int updateUserInfo(MUser user,String modifier) {
        Preconditions.checkNotNull(user.getId(),"id不能为空");
        user.setModifier(modifier);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(MUser user,String modifier) {
        Preconditions.checkNotNull(user.getId(),"id不能为空");
        user.setModifier(modifier);
        return userMapper.deleteById(user.getId());
    }

    @Override
    public List<MUser> getUserWithPage(int page, int number) {
        return userMapper.selectAllUser(new RowBounds(page,number));
    }

    @Override
    public MUser login(String username,String password,String ip) {
        Preconditions.checkNotNull(username,"id不能为空");
        Preconditions.checkNotNull(password,"id不能为空");

        MUser dataBaseUser=userMapper.selectUserByUserName(username);
        String cypherText =EncryptionUtil.md5Password(username,password,dataBaseUser.getSalt());
        if(dataBaseUser.getPassword().equals(cypherText)){
            if(Status.NORMAL.statusEquals(dataBaseUser.getStatus())){
                updateLoginInfo(dataBaseUser.getId(),ip);
                return  dataBaseUser;
            }else
                log.info("用户id:%s,已被禁用,无法登录",dataBaseUser.getId());
        }
        return null;
    }

    private void updateLoginInfo(Long id,String ip){
        MUser user=new MUser();
        user.setId(id);
        user.setLastLoginIp(ip);
        user.setLastLoginTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }
}
