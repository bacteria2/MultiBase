package com.multi;

import com.multi.data.MainConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MainConfiguration.class})
@ActiveProfiles("development")
public class BaseTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    DataSource url;
    @Autowired
    SqlSessionFactory sessionFactory;

    /*@Test
    public void dataSourceTest(){
        System.out.println(url);
    }

    @Test
    public void sessionFactoryTest(){
        System.out.println(sessionFactory);
    }*/
}
