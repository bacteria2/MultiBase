package com.multi.data.conf;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@Configuration
@MapperScan(basePackages = "com.multi.data.relationdb")
public class MybatisConfiguration {

    @Autowired
    @Qualifier("propertiesFactory")
    private Properties dbEnvironment;

    @Value("${page.helperDialect}")
    private String helperDialect;
    @Value("${page.offsetAsPageNum}")
    private String offsetAsPageNum;


    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(dbEnvironment.getProperty("dataSource.className"));
        config.setJdbcUrl(dbEnvironment.getProperty("dataSource.url"));
        config.setUsername(dbEnvironment.getProperty("dataSource.user"));
        config.setPassword(dbEnvironment.getProperty("dataSource.password"));
        config.setMaximumPoolSize(Integer.valueOf(dbEnvironment.getProperty("dataSource.maximumPoolSize")));
        return new HikariDataSource(config);
    }

    /** 分页插件 @{pageHelper}*/
    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor interceptor=  new PageInterceptor();
        Properties props=new Properties();
        props.setProperty("helperDialect",helperDialect);
        props.setProperty("offsetAsPageNum",offsetAsPageNum);
        interceptor.setProperties(props);
        return interceptor;
    }

    @Bean
    public SqlSessionFactory sessionFactoryBean(DataSource dataSource,PathMatchingResourcePatternResolver resolver,PageInterceptor interceptor ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{
                interceptor
        });
        return  sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
