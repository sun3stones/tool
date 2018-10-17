package com.lei.tool.controller;

import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.*;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import com.lei.tool.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/console")
public class ConsoleController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectTaskService projectTaskService;

    @RequestMapping("/roleList")
    public String roleList(HttpServletRequest request){

        return "console/roleList";
    }

    @RequestMapping("/roleDataList")
    @ResponseBody
    public Page<URole> roleDataList(HttpServletRequest request, Page<URole> page, URole uRole){
        page = userService.getRolePage(page,uRole);
        return  page;
    }

    @RequestMapping("/permissionList")
    public String permissionList(HttpServletRequest request,URole role){
        UUser user = getUser();
        URole uRole = userService.getRole(user);
        List<UPermission> perList = userService.getAllPermission();//获取所有权限
        List<UPermission> editList = userService.getRolePermission(uRole);//获取用户的操作权限
        List<UPermission> hasList = userService.getRolePermission(role);//获取编辑角色的权限
        List<UPermission> mlist1 = new ArrayList<>();
        List<UPermission> mlist2 = new ArrayList<>();
        List<UPermission> funcList = new ArrayList<>();
        for (UPermission permission:perList) {
            for (UPermission hasper:hasList) {
                if (hasper.getId() == permission.getId()){
                    permission.setSort(1);//如果角色拥有该权限，sort设置为1作为标识
                    break;
                }
            }
            for (UPermission editper:editList) {
                if (editper.getId() == permission.getId()){
                    permission.setIsMenu(2);//如果角色拥有该权限，IsMenu设置为2作为标识
                    break;
                }
            }
            if(permission.getLevel() == 1){//判断一级菜单
                mlist1.add(permission);
            }else if(permission.getLevel() == 2){//判断二级菜单
                mlist2.add(permission);
            }else if(permission.getLevel() == 3){//判断按钮权限
                funcList.add(permission);
            }
        }
        request.setAttribute("menuList1", mlist1);
        request.setAttribute("menuList2", mlist2);
        request.setAttribute("funcList3", funcList);
        request.setAttribute("roleId", role.getId());//编辑角色的id
        return "console/permission";
    }

    @RequestMapping("/savePermission")
    @ResponseBody
    public String savePermission(String perIds,Long roleId){
        try{
            if (StringUtils.isNotEmpty(perIds)){
                userService.updateRolePermission(perIds,roleId);
                return "修改权限成功";
            }
        }catch (Exception e){
            throw (e);
        }
        return "修改权限失败";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(URole role){
        try{
            if(role != null){
                userService.insertRole(role);
                return "新增角色成功";
            }

        }catch (Exception e){
            throw (e);
        }
        return "新增角色失败";
    }
    @RequestMapping("/deleteRole")
    @ResponseBody
    public String deleteRole(URole role){
        try{
            if(role != null){
                userService.deleteRole(role);
                return "删除角色成功";
            }

        }catch (Exception e){
            throw (e);
        }
        return "删除角色失败";
    }
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request){
        return "console/userList";
    }


    @RequestMapping("/userDataList")
    @ResponseBody
    public Page<UserDto> userDataList(HttpServletRequest request, Page<UserDto> page, UserDto user){
        page = userService.getUserPage(page,user);
        return  page;
    }

    @RequestMapping("/projectUserList")
    @ResponseBody
    public Page<UserDto> projectUserList(HttpServletRequest request, Page<UserDto> page, UserDto user){
        page = userService.getUserPage(page,user);
        return  page;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request, UserDto userDto){
        String result = "";
        if(userDto.getId() == null){//新增用户
            userService.insertUser(userDto);
            return "新增用户成功！";
        }else{//修改用户
            userService.updateUser(userDto);
            return "修改用户成功！";
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(HttpServletRequest request){
        UUser user = new UUser();
        user.setId(Long.parseLong(request.getParameter("id")));
        if(user == null || user.getId() == null){
            return "删除用户失败";
        }
        userService.deleteUser(user);
        return "成功删除用户‘"+user.getUserName()+"’！";
    }

    @RequestMapping("/updateUserStatus")
    @ResponseBody
    public String updateUserStatus(HttpServletRequest request,UserDto userDto){
        userService.updateUser(userDto);
        return "更新状态成功！";
    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public Map<String,Object> changePassword(HttpServletRequest request, String password, String newPassword){
        Map<String,Object> result = new HashMap<>();
        UserDto userDto = getUserDto();
        password = DigestUtils.md5Hex(password);
        if(!userDto.getPassword().equals(password)){
            result.put("errcode",1);
            result.put("msg","修改失败：密码输入错误！");
            return result;
        }
        userDto.setPassword(DigestUtils.md5Hex(newPassword));
        userService.updateUser(userDto);
        result.put("errcode",0);
        result.put("msg","修改密码成功！");
        return result;
    }

    @RequestMapping("/projectList")
    public String projectList(){
        return "console/projectList";
    }

    @RequestMapping("/projectDataList")
    @ResponseBody
    public Page<ProjectGroup> projectDataList(HttpServletRequest request, Page<ProjectGroup> page,ProjectGroup projectGroup){
        UUser user = getUser();
        if(isAdmin()){//管理员可查询所有的项目
            user = null;
        }
        page = projectTaskService.getProjectPage(page,projectGroup,user);
        return  page;
    }
    @RequestMapping("/addProject")
    @ResponseBody
    public Map<String,Object> addProject(HttpServletRequest request, Page<ProjectGroup> page,ProjectGroup projectGroup){
        Map<String,Object> map = new HashMap<>();
        if(projectGroup.getId() == null){//新增
            UUser user = getUser();
            return projectTaskService.addProject(projectGroup,user);
        }else{//修改
            return projectTaskService.updateProject(projectGroup,null);
        }
    }

    @RequestMapping("/projectGroupDetail")
    public String projectGroupList(HttpServletRequest request,ProjectGroup projectGroup){
        projectGroup = projectTaskService.getProject(projectGroup).get(0);
        request.setAttribute("pg",projectGroup);
        return "console/projectDetail";
    }

    @RequestMapping("/addProjectUser")
    public String addProjectUser(HttpServletRequest request,UserDto userDto){
        Page<UserDto> page = new Page<>();
        page.setLimit(100);
        page.setPage(1);
        page = userService.getUserPage(page,null);
        List<UserDto> list = page.getData();
        List<UserDto> userList = userService.getUserPage(page,userDto).getData();
        for (UserDto user:list) {
            for (UserDto user1:userList) {
                if(user1.getId() == user.getId()){
                    user.setProjectId(userDto.getProjectId());
                    break;
                }
            }
        }
        request.setAttribute("userList",list);
        return "console/addProjectUser";
    }

    @RequestMapping("/addProjectUserSave")
    @ResponseBody
    public String addProjectUserSave(HttpServletRequest request,String userIds,Long projectId){
        if(StringUtils.isNotEmpty(userIds)){
            ProjectGroupUser pgu = new ProjectGroupUser();
            pgu.setGid(projectId);
            String[] ids = userIds.split(",");
            for (String id:ids) {
                pgu.setUid(Long.parseLong(id));
                projectTaskService.addProjectUser(pgu);
            }
        }
        return "添加成员成功！";
    }

    @RequestMapping("/timeLine")
    public String timeLine(HttpServletRequest request,String userIds,Long projectId){
        return "console/timeLine";
    }



}
