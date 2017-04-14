package com.multi.auth.shiro.realm;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import com.multi.auth.shiro.service.PermissionService;
import com.multi.auth.shiro.service.UserService;
import com.multi.data.relationdb.user.MUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        MUser user=(MUser)SecurityUtils.getSubject().getPrincipal() ;
        SimpleAuthorizationInfo authorizationInfo=  new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permissionService.getUserResourceById(user.getId() ));
        authorizationInfo.addRoles(permissionService.getUserRolesById(user.getId()));
        return authorizationInfo;
    }

    /**login*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object username=token.getPrincipal();
        Object password=String.valueOf((char[])token.getCredentials());
        Session session=SecurityUtils.getSubject().getSession();
        String host= Strings.nullToEmpty(session.getHost());
        Preconditions.checkNotNull(username,"username不能为空");
        Preconditions.checkNotNull(password,"password不能为空");
        MUser user= null;
        try {
            user = userService.login(username.toString(),password.toString(),host);
        } catch (UserPrincipalNotFoundException e) {
            e.printStackTrace();
            throw new AuthenticationException("用户不存在");
        }
        Preconditions.checkNotNull(user);
        return new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(user.getSalt()),getName());
    }
}
