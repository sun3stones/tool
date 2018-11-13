package com.lei.tool.controller;

import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UUser;
import com.lei.tool.filter.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class BaseController {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserDto getUserDto(){
        return (UserDto) SecurityUtils.getSubject().getPrincipal();
    }

    public UUser getUser(){
        UserDto userDto = (UserDto) SecurityUtils.getSubject().getPrincipal();
        UUser user = new UUser();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }

    boolean isAdmin(){
        return SecurityUtils.getSubject().hasRole("管理员");
    }

    /**
     * 重新加载用户权限
     * @param userDto
     */
    public void reloadAuthorizing(UserDto userDto){
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm myRealm = (MyShiroRealm)rsm.getRealms().iterator().next();
        Subject subject = SecurityUtils.getSubject();
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        //第一个参数为用户,第二个参数为realmName
        SimplePrincipalCollection principals = new SimplePrincipalCollection(userDto,realmName);
        subject.runAs(principals);
    }

}
