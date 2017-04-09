package com.multi.test.data.dao;

import com.alibaba.fastjson.JSON;

import com.multi.common.util.DateTimeUtil;
import com.multi.data.relationdb.role.MRole;
import com.multi.data.relationdb.role.dao.MRoleMapper;
import com.multi.data.relationdb.user.MUser;

import com.multi.data.relationdb.user.dao.MUserMapper;

import com.multi.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shepard.xia
 * @date 2017年03月27日
 * @description input useage
 */
public class UPermissionMapperTest extends BaseTest {
     @Autowired
    MRoleMapper roleMapper;
     @Autowired
    MUserMapper userMapper;


    @Test
    public void permissionTest(){


        String json= JSON.toJSONString(userMapper.selectUserRolesByUserId(3L));
        System.out.println(json);
        String json2= JSON.toJSONString(userMapper.selectAllUser());
        System.out.println(json2);

        String json3= JSON.toJSONString(roleMapper.selectRoleUsersByRoleId(3L));
        System.out.println(json3);
        String json4= JSON.toJSONString(roleMapper.selectAllRole());
        System.out.println(json4);
    }

    @Test
    public void testUpdate(){
       MRole role=new MRole();
        role.setId(4L);
        role.setRole(3334);

        roleMapper.updateByPrimaryKeySelective(role);
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(DateTimeUtil.CurrentTimeString("yyyy-MM-dd HH:mm:ss.SSS"));

    }

}