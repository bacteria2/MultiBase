package com.multi;

import com.multi.data.MainConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author shepard.xia
 * @date 2017年03月16日
 * @description input useage
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MainConfiguration.class})
public class BaseTest extends AbstractJUnit4SpringContextTests {

    @Autowired

    DataSource url;

    @Test
    public void test(){
        System.out.println(url);
    }

}
