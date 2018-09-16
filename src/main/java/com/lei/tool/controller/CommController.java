package com.lei.tool.controller;

import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comm")
public class CommController {

    @Autowired
    private UserService userService;

    @RequestMapping("/initRoleSelect")
    @ResponseBody
    public Map<String, Object> roleDataList(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            UUser user = (UUser) SecurityUtils.getSubject().getPrincipal();
            List<URole> list = userService.getInitRole(user);
            result.put("errcode","0");
            result.put("data",list);
        } catch (Exception e) {
            result.put("errcode","1");
            return  result;
        }
        return result;
    }
}
