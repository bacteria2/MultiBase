package com.multi.webadmin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.multi.auth.shiro.realm.ShiroToken;
import com.multi.data.model.UUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by IonCannon on 2016/11/19.
 */
@RestController
public class DemoController {
    @RequestMapping("show")
    public Map demoShow() {
        return ImmutableMap.of("test1","1","test2","2");
    }


    @RequestMapping("index")
    public String index() {
        return "{\"path\":\"index\"}";
    }

    @RequestMapping("/login/submit")
    public String submitLogin(UUser user, Boolean rememberMe, HttpServletRequest request){
        ShiroToken token = new ShiroToken(user.getEmail(), user.getPswd());
        token.setRememberMe(rememberMe);
        SecurityUtils.getSubject().login(token);
        return "{\"login\":\"success\"}";
    }

}
