package com.multi.auth.shiro.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.multi.auth.shiro.EncryptionUtil;
import com.multi.auth.shiro.MResponse;
import com.multi.data.relationdb.Status;
import com.multi.data.relationdb.user.MUser;
import com.multi.data.relationdb.user.dao.MUserMapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description 用户查询修改禁用等功能
 */
@Service
public class UserService {

    private Logger log= LoggerFactory.getLogger(UserService.class);

    @Autowired
    MUserMapper userMapper;

    public MResponse<Integer> insertNewUser(MUser user, String creator) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getUsername()),"username不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getPassword()),"password不能为空");
        if(userMapper.userExistCheck(user).size()>0){
            return new MResponse<>("用户名或者mobile或者email已存在",2);
        }
        else {
            log.info("新增一条用户记录,用户名{}",user.getUsername());
            user.setCreator(creator);
            user.setModifier(creator);
            int code=userMapper.insertSelective(  EncryptionUtil.md5Password(user));
            return new MResponse<>("新增用户成功",code);
        }
    }

    public int updateUserInfo(MUser user,String modifier) {
        Preconditions.checkNotNull(user.getId(),"id不能为空");
        user.setModifier(modifier);
        log.info("用户id:{} 更新信息",user.getId());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int deleteUser(MUser user,String modifier) {
        Preconditions.checkNotNull(user.getId(),"id不能为空");
        user.setModifier(modifier);
        log.info("用户id:{} 删除用户",user.getId());
        return userMapper.deleteById(user.getId());
    }

    public int updateUserPassword(MUser user, String password, String modifier) {
        Preconditions.checkNotNull(user.getId(),"id不能为空");
        Preconditions.checkState(!Strings.isNullOrEmpty(password),"password不能为空");
        user.setPassword(password);
        EncryptionUtil.md5Password(user);
        user.setModifier(modifier);
        log.info("用户id:{} 修改密码",user.getId());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<MUser> getUserWithPage(int page, int number) {
        return userMapper.selectAllUser(new RowBounds(page,number));
    }


    public MResponse addUserRole(MUser user) {
        return null;
    }


    public MUser login(String username,String password,String ip) throws UserPrincipalNotFoundException {
        Preconditions.checkNotNull(username,"id不能为空");
        Preconditions.checkNotNull(password,"id不能为空");

        MUser dataBaseUser=userMapper.selectUserByUserName(username);
        if (dataBaseUser==null)
            throw new UserPrincipalNotFoundException(String.format("未找到usernmame为%s的用户",username));
        String cypherText =EncryptionUtil.md5Password(username,password,dataBaseUser.getSalt());
        if(dataBaseUser.getPassword().equals(cypherText)){
            if(!(Status.DISABLED.statusEquals(dataBaseUser.getStatus())||Status.BANNED.statusEquals(dataBaseUser.getStatus()))){
                updateLoginInfo(dataBaseUser.getId(),ip);
                log.info("用户id:{} 登录系统",dataBaseUser.getId(),dataBaseUser.getUsername());
                return  dataBaseUser;
            }else
                log.info("用户id:{},用户名:{}. 已被禁用,无法登录",dataBaseUser.getId(),dataBaseUser.getUsername());
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
