package com.lei.tool.controller;

import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, UUser user, @RequestParam(value = "rememberMe", required = false) boolean rememberMe) {
        if (user == null) {
            return "login";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), DigestUtils.md5Hex(user.getPassword()), rememberMe);
        SecurityUtils.getSubject().login(token);
        return "forward:/index";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        UUser user = (UUser) SecurityUtils.getSubject().getPrincipal();
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
        request.setAttribute("user",user);
        request.setAttribute("role",role);
        return "index";
    }


}