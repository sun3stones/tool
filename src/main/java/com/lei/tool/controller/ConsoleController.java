package com.lei.tool.controller;

import com.lei.tool.entity.URole;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/rolelist")
    public String rolelist(HttpServletRequest request){
        return "console/rolelist";
    }

    @RequestMapping("/roledatalist")
    @ResponseBody
    public Page<URole> roledatalist(HttpServletRequest request, Page<URole> page, URole uRole){
        page = userService.getRolePage(page,uRole);
        return  page;
    }
}
