package com.multi.auth.shiro.conf;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.multi.auth.shiro.CustomSessionDAO;
import com.multi.auth.shiro.filter.LoginFilter;
import com.multi.auth.shiro.filter.PermissionFilter;
import com.multi.auth.shiro.filter.RoleFilter;
import com.multi.auth.shiro.filter.SimpleAuthFilter;
import com.multi.auth.shiro.realm.SampleRealm;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

/**
 * @author shepard.xia
 * @date 2017年03月28日
 * @description input useage
 */
@Configuration
public class ShiroConfiguration {
    /**
     * session生成器
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 基础cookie
     */
    @Bean(name = "simpleCookie", autowire = Autowire.BY_NAME)
    public Cookie simpleCookie() {
        Cookie cookie = new SimpleCookie("com-multi-simple");
        cookie.setHttpOnly(true);
        //保存7天
        cookie.setMaxAge(-1);
        return cookie;
    }

    /**
     * 记住我cookie，可以保存7天
     */
    @Bean(name = "rememberMe", autowire = Autowire.BY_NAME)
    public Cookie rememberMe() {
        Cookie cookie = new SimpleCookie("com-multi-remember");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600 * 7);
        return cookie;
    }

    @Bean(name="customSessionDAO")
    public CustomSessionDAO customSessionDAO(){
        return new CustomSessionDAO();
    }

    @Bean
    public SessionManager defaultWebSessionManager(@Qualifier("customSessionDAO")CustomSessionDAO dao, @Qualifier("simpleCookie")Cookie sessionIdCookie,CacheManager cacheManager){
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();

        //VALIDATOR
        QuartzSessionValidationScheduler validationScheduler=new QuartzSessionValidationScheduler();
        validationScheduler.setSessionValidationInterval(1800000);
        validationScheduler.setSessionManager(sessionManager);

        sessionManager.setCacheManager(cacheManager);
        sessionManager.setSessionValidationInterval(1800000);
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setSessionIdCookie(sessionIdCookie);
        sessionManager.setSessionDAO(dao);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationScheduler(validationScheduler);
        return sessionManager;
    }


    @Bean
    public CookieRememberMeManager rememberMeManager(@Qualifier("rememberMe")Cookie rememberMe){
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        manager.setCookie(rememberMe);
        return manager;
    }

    /**
     * 使用shiro自带的cacheManger来保存Session
     */
    @Bean
    public MemoryConstrainedCacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public Realm simpleRealm(){
        return new SampleRealm();
    }

    @Bean
    public SessionsSecurityManager sessionsSecurityManager(Realm realm,SessionManager manager, CookieRememberMeManager rememberMe,CacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setSessionManager(manager);
        securityManager.setRememberMeManager(rememberMe);
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }

    @Bean
    public LifecycleBeanPostProcessor shiroLifecycleBeanProcessor(){
        return new LifecycleBeanPostProcessor();
    }


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SessionsSecurityManager manager) throws Exception {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setFilters(ImmutableMap.of("simple",new SimpleAuthFilter(),"login",new LoginFilter(),"role",new RoleFilter(),"permission",new PermissionFilter()));
        factoryBean.setSecurityManager(manager);
        ClassPathResource resource=new ClassPathResource("shiro_filter_chain",this.getClass().getClassLoader());
        factoryBean.setFilterChainDefinitions(Files.toString(resource.getFile(), StandardCharsets.UTF_8));
        factoryBean.setLoginUrl("/asset/login.html");
        return factoryBean;
    }
}
