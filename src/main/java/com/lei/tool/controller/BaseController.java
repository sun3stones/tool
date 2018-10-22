package com.lei.tool.controller;

import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;

public class BaseController {

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
}
