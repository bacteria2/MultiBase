package com.shepard;

import com.shepard.config.AppConfig;
import com.shepard.config.MvcConfig;

import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * @decription 代替web.xml配置servlet
 * Created by IonCannon on 2016/11/20.
 */
public class MultiDemoWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
/*
        DelegatingFilterProxy shiroFilter=new DelegatingFilterProxy();
        shiroFilter.setTargetFilterLifecycle(true);*/

        return new Filter[] {characterEncodingFilter};
    }

    public MultiDemoWebInitializer() {
        super();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }



    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

}
