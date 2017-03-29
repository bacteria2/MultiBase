package com.multi;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * @author multi.xia
 * @date 2017年03月16日
 * @description input useage
 */
@Configuration
@ComponentScan
public class MainConfiguration {

    @Bean
    public PathMatchingResourcePatternResolver resolver() {
        return new PathMatchingResourcePatternResolver();
    }

    /**
     * 注入属性for development
     */
    @Bean(name = "propertiesFactory")
    public PropertiesFactoryBean devPropertiesFactoryBean(PathMatchingResourcePatternResolver resolver) throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(
                resolver.getResources("classpath*:*_dev.properties")
        );
        return propertiesFactoryBean;
    }

    /**
     * 注入属性for production
     */
    @Bean(name = "propertiesFactory")
    @Profile("production")
    public PropertiesFactoryBean prodPropertiesFactoryBean(PathMatchingResourcePatternResolver resolver) throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(
                resolver.getResource("classpath*:*_prod.properties")
        );
        return propertiesFactoryBean;
    }

    /**
     * 解析形如 @Value("${dataSource.className}")
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(PropertiesFactoryBean factoryBean) throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(factoryBean.getObject());
        return configurer;
    }

    @Bean
    public BeanPostProcessor postProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                if (beanName.matches(".*Control(ler)?")) {
                    System.out.println("============================================");
                    System.out.println(beanName);
                }
                return bean;
            }
        };
    }


}
