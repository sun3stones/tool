package com.lei.tool.controller;

import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value={"/loginAction"})
    @ResponseBody
    public Map<String,Object> loginAction(HttpServletRequest request, UUser user) {
        Map<String,Object> result = new HashMap<>();
        Integer errcode = 1;
        String msg = "";
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), DigestUtils.md5Hex(user.getPassword()));
            SecurityUtils.getSubject().login(token);
            errcode = 0;
            msg = "登录成功！";
            return result;
        } catch (UnknownAccountException  ua){
            msg = "用户不存在！";
        } catch (IncorrectCredentialsException ic){
            msg = "密码错误！";
        } catch (DisabledAccountException ic){
            msg = "用户禁止登录！";
        }finally {
            result.put("errcode",errcode);
            result.put("msg",msg);
            return result;
        }

    }

    @RequestMapping(value={"/index",""})
    public String index(HttpServletRequest request) {
        UUser user = getUser();
        UserDto userDto = getUserDto();
        URole role = userService.getRole(user);
        List<UPermission> mlist = userService.getMenu(user);
        List<UPermission> mlist1 = new ArrayList<>();
        List<UPermission> mlist2 = new ArrayList<>();
        for (UPermission menu:mlist) {
            if(menu.getLevel() == 1){
                mlist1.add(menu);
            }else if(menu.getLevel() == 2){
                mlist2.add(menu);
            }
        }
        request.setAttribute("menuList1", mlist1);
        request.setAttribute("menuList2", mlist2);
        request.setAttribute("user",userDto);
        request.setAttribute("role",role);
        return "index";
    }

    @RequestMapping("changeHeadImg")
    @ResponseBody
    public Map<String,String> changeHeadImg(HttpServletRequest request, String img){
        Map<String,String> result = new HashMap<>();
        UserDto userDto = getUserDto();
        String path = "http://"+request.getServerName()+":"+request.getServerPort();
        if(img.contains(path)){
            img = img.replace(path,"");
        }
        userDto.setHeadImg(img);
        userService.updateUser(userDto);
        result.put("img",img);
        result.put("msg","修改头像成功！");
        return result;
    }



}
