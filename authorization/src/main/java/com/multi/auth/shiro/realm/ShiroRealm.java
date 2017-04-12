package com.multi.auth.shiro.realm;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.multi.auth.shiro.service.UserServiceImpl;
import com.multi.data.relationdb.user.MUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        principals.getRealmNames();
        return null;
    }

    /**login*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object username=token.getPrincipal();
        Object password=token.getCredentials();
        Session session=SecurityUtils.getSubject().getSession();
        String host= Strings.nullToEmpty(session.getHost());
        Preconditions.checkNotNull(username,"username不能为空");
        Preconditions.checkNotNull(password,"password不能为空");
        MUser user= userService.login(username.toString(),password.toString(),host);
        Preconditions.checkNotNull(user);
        return new SimpleAuthenticationInfo(username,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }
}
