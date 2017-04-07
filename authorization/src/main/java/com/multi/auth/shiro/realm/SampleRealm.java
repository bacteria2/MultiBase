package com.multi.auth.shiro.realm;

import com.google.common.base.Preconditions;
import com.multi.auth.shiro.service.IPermissionService;
import com.multi.auth.shiro.service.IRoleService;
import com.multi.auth.shiro.service.IUserService;
import com.multi.data.model.UUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import java.util.Date;
import java.util.Set;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
public class SampleRealm extends AuthorizingRealm {

    private IUserService userService=new IUserService(){};

    private IRoleService roleService=new IRoleService(){};

    private IPermissionService permissionService=new IPermissionService() {};



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UUser user=(UUser) SecurityUtils.getSubject();
        Long userId = user==null?null:user.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roles = roleService.findRoleByUserId(userId);
        info.setRoles(roles);
        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = permissionService.findPermissionByUserId(userId);
        info.setStringPermissions(permissions);
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {


        UUser user = userService.login(authToken.getPrincipal().toString(),authToken.getCredentials().toString());
        Preconditions.checkNotNull(user,"error account or password");
        Preconditions.checkState(UUser._1.equals(user.getStatus()),"account has been terminated");

        //更新登录时间 last login time
        user.setLastLoginTime(new Date());
        //userService.updateByPrimaryKeySelective(user);
        return  new SimpleAuthenticationInfo(user,user.getPswd(), getName());
    }

    /**
     * 清空当前用户权限信息
     */
    public  void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
