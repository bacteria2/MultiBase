package com.multi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author IonCannon
 * @date 2016/11/20
 * @decription :
 * <p>@Configuration 注解声明该类为spring配置文件，类似applicationContext.xml配置文件
 * <br>@ComponentScan 注解配置扫描全包，排除注解为EnableWebMvc的类，避免重复注入</p>
 */

@Configuration
@ComponentScan(basePackages = {"com.multi"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@ImportResource(locations = "classpath*:application.xml")
public class AppConfig {
    @Resource(name = "ymlProperties")
    private Properties properties;

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig(properties);
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


   /* @Bean
    public ShiroFilterFactoryBean shiroBean(){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();

    }
*/

}
