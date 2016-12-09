package com.shepard.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IonCannon
 * @date 2016/11/20
 * @decription :类似spring-mvc。xml配置，只扫描controller注解类
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.shepard"
       /* ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = RestController.class)}*/)
@ImportResource(locations = "classpath*:application.xml")
public class MvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    // equals: <mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(jacksonMessageConvert());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    private HttpMessageConverter jacksonMessageConvert(){
        //Set HTTP Message converter using a JSON implementation.
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        // Add supported media type returned by BI API.
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(new MediaType("text", "plain"));
        supportedMediaTypes.add(new MediaType("application", "json"));
        jsonMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return jsonMessageConverter;
    }
}
