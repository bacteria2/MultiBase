package com.shepard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author IonCannon
 * @date 2016/11/20
 * @decription :
 * <p>@Configuration 注解声明该类为spring配置文件，类似applicationContext.xml配置文件
 *    <br>@ComponentScan 注解配置扫描全包，排除注解为EnableWebMvc的类，避免重复注入</p>
 *
 */

@Configuration
@ComponentScan(basePackages = {"com.shepar"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class AppConfig {
}
