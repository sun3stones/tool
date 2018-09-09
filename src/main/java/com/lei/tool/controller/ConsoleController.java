package com.lei.tool.controller;

import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import com.lei.tool.utils.StringUtils;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.im.InputMethodWindow;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @RequestMapping("/permissionlist")
    public String permissionlist(HttpServletRequest request,URole role){
        UUser user = (UUser) SecurityUtils.getSubject().getPrincipal();
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
}
