package com.lei.tool.controller;

import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.service.UserService;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/comm")
public class CommController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectTaskService projectTaskService;

    @RequestMapping("/initRoleSelect")
    @ResponseBody
    public Map<String, Object> roleDataList(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            UUser user = getUser();
            List<URole> list = userService.getInitRole(user);
            result.put("errcode","0");
            result.put("data",list);
        } catch (Exception e) {
            result.put("errcode","1");
            return  result;
        }
        return result;
    }

    @RequestMapping("/initProjectSelect")
    @ResponseBody
    public Map<String, Object> projectDataList(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            UUser user = getUser();
            List<ProjectGroup> list = new ArrayList<>();
            if(isAdmin()){
                list = projectTaskService.getInitProject(null);
            }else{
                list = projectTaskService.getInitProject(user);
            }
            List<Map<String,Object>> data = new ArrayList<>();
            for (ProjectGroup pg:list) {
                Map<String,Object> map = new HashMap<>();
                map.put("id",pg.getId());
                map.put("name",pg.getProjectName());
                data.add(map);
            }
            result.put("errcode","0");
            result.put("data",data);
        } catch (Exception e) {
            result.put("errcode","1");
            return  result;
        }
        return result;
    }


}
