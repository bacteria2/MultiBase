package com.multi.auth.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
public class ShiroToken extends UsernamePasswordToken  {

    public ShiroToken(String username, String pswd) {
        super(username,pswd);
        this.pswd = pswd ;
    }

    /** 登录密码[字符串类型] 因为父类是char[] ] **/
    private String pswd ;

    public String getPswd() {
        return pswd;
    }


    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
