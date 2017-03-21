package com.multi.data;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@Configuration
@ComponentScan
public class MainConfiguration {

    @Bean
    public  PathMatchingResourcePatternResolver resolver(){
        return new PathMatchingResourcePatternResolver();
    }

    /**
     * 注入属性for development
     * */
    @Bean(name="propertiesFactoryBean")
    @Profile("development")
    public PropertiesFactoryBean devPropertiesFactoryBean(PathMatchingResourcePatternResolver resolver) throws IOException {
        PropertiesFactoryBean propertiesFactoryBean=new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(
                resolver.getResource("classpath:db_dev.properties")
        );
        return propertiesFactoryBean;
    }

    /**
     * 注入属性for production
     * */
    @Bean(name="propertiesFactoryBean")
    @Profile("production")
    public PropertiesFactoryBean prodPropertiesFactoryBean(PathMatchingResourcePatternResolver resolver) throws IOException {
        PropertiesFactoryBean propertiesFactoryBean=new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(
                resolver.getResource("classpath:db_prod.properties")
        );
        return propertiesFactoryBean;
    }

    /**
     * 解析形如 @Value("${dataSource.className}")
     * */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(PropertiesFactoryBean factoryBean) throws IOException {
        PropertySourcesPlaceholderConfigurer configurer= new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(factoryBean.getObject());
        return configurer;
    }
}
