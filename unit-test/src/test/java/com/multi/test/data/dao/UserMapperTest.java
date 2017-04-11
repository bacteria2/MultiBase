package com.multi.test.data.dao;

import com.alibaba.fastjson.JSON;
import com.multi.data.relationdb.Status;
import com.multi.data.relationdb.user.MUser;
import com.multi.data.relationdb.user.dao.MUserMapper;
import com.multi.test.BaseTest;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @author IonCannon
 * @date 2017/4/9
 * @decription : content
 */
public class UserMapperTest extends BaseTest {
    @Autowired
    MUserMapper userMapper;


    @Test
    public void insertNewUser(){
        MUser mUser=new MUser();

        mUser.setEmail("2123213123"+System.currentTimeMillis());
        mUser.setLastLoginIp("2222.2222");
        userMapper.insertSelective(mUser);
    }

    @Test
    public void selectUser(){
          userMapper.selectAllUser(new RowBounds(1,2)).forEach(el->System.out.println(JSON.toJSONString(el)));

          userMapper.selectUserByUserName("1");
    }

    @Test
    public void selectEnum(){

        System.out.println(Status.valueOf("Bannd"));
    }

}
