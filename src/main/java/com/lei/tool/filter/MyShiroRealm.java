package com.lei.tool.filter;

import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权用户权限
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UUser user = (UUser) principalCollection.getPrimaryPrincipal();
        //把用户所有拥有的角色及权限放入
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //角色
            URole role = userService.getRole(user);
            info.addRole(role.getName());
            //权限
            List<UPermission> permissions = userService.getPermission(user);
            for (UPermission p : permissions) {
                info.addStringPermission(p.getName());
            }
            return info;
        }
        return null;
    }

    /**
     * 验证用户身份
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        UUser user = new UUser();
        user.setUserName(userName);
        user = userService.selectUser(user);
        if (user == null) {
            throw new AccountException("账户不存在");
        }
        if (user.getStatus() == 0) {
            throw new DisabledAccountException("账号已经禁止登录");
        } else {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
    }
}
