package com.multi.auth.web.controller;

import com.multi.data.model.UUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shepard.xia
 * @date 2017年03月31日
 * @description input useage
 */
@Controller
@RequestMapping("/login")
public class LoginAndRegistryController {


    @RequestMapping("submit")
    public String submitLogin(UUser user, Boolean rememberMe, HttpServletRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPswd());
        token.setRememberMe(rememberMe);
        SecurityUtils.getSubject().login(token);
        return "{\"login\":\"success\"}";
    }
}
