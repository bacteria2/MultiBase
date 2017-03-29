package com.multi.test.data.dao;


import com.multi.data.dao.MultiUserMapper;
import com.multi.data.model.MultiUser;
import com.multi.test.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shepard.xia
 * @date 2017年03月21日
 * @description input useage
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MultiUserMapperTest extends BaseTest {
    @Autowired
    MultiUserMapper multiUserMaMapper;


    @Test
    public void deleteByPrimaryKey() throws Exception {
        MultiUser user=new  MultiUser();
        Long timestamp=System.currentTimeMillis();
        // user.setId(timestamp);
        user.setName("testDelete"+timestamp);
        user.setPhone(7890);
        multiUserMaMapper.insert(user);
        System.out.println(user.getId());
        multiUserMaMapper.deleteByPrimaryKey(user.getId());
    }

    @Test
    public void insert() throws Exception {
        Map map=new HashMap();

        MultiUser user=new  MultiUser();
        Long timestamp=System.currentTimeMillis();
        // user.setId(timestamp);
        user.setName("testInsert"+timestamp);
        user.setPhone(3677);
        multiUserMaMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        MultiUser user=new  MultiUser();
        Long timestamp=System.currentTimeMillis();
        // user.setId(timestamp);
        user.setName("testSelect"+timestamp);
        user.setPhone(3670);
        multiUserMaMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void selectAll() throws Exception {
     //   multiUserMaMapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        MultiUser user=new  MultiUser();
        Long timestamp=System.currentTimeMillis();
        user.setName("testUpdate"+timestamp);
        user.setPhone(36890);
        user.setName("updated");
        multiUserMaMapper.insert(user);
        System.out.println(user.getId());
        multiUserMaMapper.updateByPrimaryKey(user);
    }

    private Long insertNewAndReturnKey(String Name) throws InterruptedException {
        MultiUser user=new  MultiUser();
        Long timestamp=System.currentTimeMillis();
       // user.setId(timestamp);
        user.setName("test"+Name+timestamp);
        user.setPhone(34567890);
        multiUserMaMapper.insert(user);
        Thread.sleep(500);
        return user.getId();
    }

}