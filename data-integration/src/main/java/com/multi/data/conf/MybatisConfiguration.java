package com.multi.data.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author shepard.xia
 * @date 2017年03月16日
 * @description input useage
 */
@Configuration
@PropertySource("db.properties")
public class MybatisConfiguration {

    @Autowired
    private Properties dbEnvironment;


    @Bean
    public DataSource dataSource(){


        HikariConfig config=new HikariConfig(dbEnvironment);
        return new HikariDataSource(config);
    }
}
