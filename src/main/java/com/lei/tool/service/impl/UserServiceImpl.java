package com.lei.tool.service.impl;

import com.github.pagehelper.PageHelper;
import com.lei.tool.entity.*;
import com.lei.tool.mapper.*;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import com.lei.tool.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UUserMapper userMapper;
    @Autowired
    private UPermissionMapper permissionMapper;
    @Autowired
    private URoleMapper roleMapper;
    @Autowired
    private URolePermissionMapper rolePermissionMapper;
    @Autowired
    private UUserRoleMapper userRoleMapper;

    @Override
    public UUser selectUser(UUser user) {
        user = userMapper.selectOne(user);
        return user;
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public URole getRole(UUser user) {
        return roleMapper.selectRole(user);
    }

    @Override
    public List<URole> getroleList(String roleName) {
        Example ex = new Example(URole.class);
        if(StringUtils.isNotEmpty(roleName)){
            ex.createCriteria().andEqualTo("name",roleName);
        }else{
            return roleMapper.selectAll();
        }


        return roleMapper.selectByExample(ex);
    }

    @Override
    public Page<URole> getRolePage(Page<URole> page, URole uRole) {
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<URole> list = new ArrayList<>();
        if(StringUtils.isEmpty(uRole.getName())){
            list = roleMapper.selectAll();
        }else{
            list = roleMapper.select(uRole);
        }
        page.setCount(roleMapper.selectCount(uRole));
        page.setData(list);
        page.setCode(0);
        page.setMsg("成功");
        return page;
    }

    @Override
    public List<UPermission> getPermission(UUser user) {
        return permissionMapper.selectPermission(user);
    }

    @Override
    public List<UPermission> getRolePermission(URole uRole) {
        return permissionMapper.selectRolePermission(uRole);
    }

    @Override
    public List<UPermission> getMenu(UUser user) {
        return permissionMapper.selectMenu(user);
    }

    @Override
    public List<UPermission> getAllMenu() {
        return permissionMapper.selectAllMenu();
    }

    @Override
    public List<UPermission> getAllPermission() {
        return permissionMapper.selectAll();
    }

    @Override
    public int updateRolePermission(String perIds, Long id) {
        int i = 0;
        Example ex = new Example(URolePermission.class);
        ex.createCriteria().andEqualTo("rid",id);
        rolePermissionMapper.deleteByExample(ex);
        URolePermission rolePermission = new URolePermission();
        rolePermission.setRid(id);
        String[] pids =  perIds.split(",");
        for (String pid:pids) {
            rolePermission.setPid(Long.parseLong(pid));
            i += rolePermissionMapper.insert(rolePermission);
        }
        return i;
    }

    @Override
    public int insertRole(URole role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int deleteRole(URole role) {
        return roleMapper.deleteByPrimaryKey(role.getId());
    }

    @Override
    public Page<UUser> getUserPage(Page<UUser> page, UUser user) {
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<UUser> list = new ArrayList<>();
        if(StringUtils.isEmpty(user.getUserName())){
            list = userMapper.selectAll();
        }else{
            list = userMapper.select(user);
        }
        page.setCount(userMapper.selectCount(user));
        page.setData(list);
        page.setCode(0);
        page.setMsg("成功");
        return page;
    }

    @Override
    public List<URole> getInitRole(UUser user) {
        URole role = roleMapper.selectRole(user);
        Example ex = new Example(URole.class);
        ex.createCriteria().andLessThanOrEqualTo("level",role.getLevel());
        return roleMapper.selectByExample(ex);
    }

    @Override
    public String insertUser(UUser user, Long roleId) {
        UUser verify = new UUser();
        verify.setUserName(user.getUserName());
        if(userMapper.selectCount(verify)>0){
            return "新增用户失败：用户名已存在！";
        }
        user.setPassword(DigestUtils.md5Hex("123456"));
        userMapper.insertSelective(user);
        UUserRole ur = new UUserRole();
        ur.setUid(user.getId());
        ur.setRid(roleId);
        userRoleMapper.insert(ur);
        return "新增用户成功！";
    }

    @Override
    public int deleteUser(UUser user) {
        UUserRole ur = new UUserRole();
        ur.setUid(user.getId());
        userRoleMapper.delete(ur);
        return userMapper.delete(user);
    }

    @Override
    public int updateUser(UUser user, Long roleId) {
        Example exUserRole = new Example(UUserRole.class);
        exUserRole.createCriteria().andEqualTo("uid",user.getId());
        UUserRole userRole = new UUserRole();
        userRole.setUid(user.getId());
        if(roleId != null){
            userRole.setRid(roleId);
            userRoleMapper.updateByExampleSelective(userRole,exUserRole);
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }


}