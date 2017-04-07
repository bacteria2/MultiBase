package com.multi.auth.web.controller;

import com.multi.auth.web.bo.ResponseModel;
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
    public ResponseModel<UUser> submitLogin(UUser user, Boolean rememberMe, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPswd());
        token.setRememberMe(rememberMe);
        SecurityUtils.getSubject().login(token);

        return new ResponseModel<>("success", 1, user);
    }

    @RequestMapping("/registry")
    public ResponseModel<UUser> registry(UUser user){
        //TODO
        return new ResponseModel<>("success", 1, user);
    }

    @RequestMapping("/resetPassword")
    public ResponseModel<UUser> resetPassword(UUser user){
        //TODO
        return new ResponseModel<>("success", 1, user);
    }

    @RequestMapping("logout")
    public ResponseModel<UUser> logout(UUser user, HttpServletRequest request) {
        //TODO
        return new ResponseModel<>("success", 1, user);
    }
}