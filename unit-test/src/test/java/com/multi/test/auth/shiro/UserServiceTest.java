package com.multi.test.auth.shiro;

import com.multi.auth.shiro.service.UserService;
import com.multi.data.relationdb.Status;
import com.multi.data.relationdb.user.MUser;
import com.multi.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public class UserServiceTest extends BaseTest{

    @Autowired
    UserService service;

    @Test
    public void addNewUser(){
        MUser user=new MUser();
        user.setUsername("babwwwwe");
        user.setPassword("test");
        user.setEmail("xia8910168@Hotmai.com");
        user.setNickname("三只流浪猫");
        user.setMobile("18620725670");
        user.setStatus(Status.NORMAL.getStatus());
        service.insertNewUser(user,"shepard.xia");
    }

    @Test
    public void updateTest(){

    }

    @Test
    public void loginTest(){
       MUser user= service.login("ubeadq","test111111","1.1.1.1");
       if(user!=null)
           System.out.println(user.getId());
    }

    @Test
    public void disabledTest(){

    }

}
