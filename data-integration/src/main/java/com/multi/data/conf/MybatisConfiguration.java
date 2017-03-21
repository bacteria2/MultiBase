package com.multi.data.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@Configuration

//@PropertySource("db.properties")
public class MybatisConfiguration {

    @Autowired
    @Qualifier("propertiesFactory")
    private Properties dbEnvironment;

    @Value("${dataSource.url}")
    private String a;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(dbEnvironment.getProperty("dataSource.className"));
        config.setJdbcUrl(dbEnvironment.getProperty("dataSource.url"));
        config.setUsername(dbEnvironment.getProperty("dataSource.user"));
        config.setPassword(dbEnvironment.getProperty("dataSource.password"));
        config.setMaximumPoolSize(Integer.valueOf(dbEnvironment.getProperty("dataSource.maximumPoolSize")));
        return new HikariDataSource(config);
    }

    @Bean
    public SqlSessionFactory sessionFactoryBean(DataSource dataSource,PathMatchingResourcePatternResolver resolver ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/*.xml"));
        return  sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
