package com.multi.test;

import com.multi.MainConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MainConfiguration.class})
@WebAppConfiguration
@ActiveProfiles("development")
public class BaseTest extends AbstractJUnit4SpringContextTests {


    @Test
    public void test(){
        System.out.println(1111111);
    }

}
