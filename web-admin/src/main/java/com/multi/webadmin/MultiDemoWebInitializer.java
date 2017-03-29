package com.multi.webadmin;

import com.multi.webadmin.conf.AppConfig;
import com.multi.webadmin.conf.MvcConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @decription 代替web.xml配置servlet
 * Created by IonCannon on 2016/11/20.
 */

//@WebInitParam(name="spring.profile.active",value="production")
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
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //设置spring启动的环境变量
       // servletContext.setInitParameter("spring.profiles.active","production");
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
