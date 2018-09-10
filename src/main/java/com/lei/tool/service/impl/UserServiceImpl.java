package com.lei.tool.service.impl;

import com.github.pagehelper.PageHelper;
import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.URolePermission;
import com.lei.tool.entity.UUser;
import com.lei.tool.mapper.UPermissionMapper;
import com.lei.tool.mapper.URoleMapper;
import com.lei.tool.mapper.URolePermissionMapper;
import com.lei.tool.mapper.UUserMapper;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import com.lei.tool.utils.StringUtils;
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
    public List<URole> getRoleList(String roleName) {
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
        List<URole> list = new ArrayList<URole>();
        Example ex = new Example(URole.class);
        if(StringUtils.isNotEmpty(uRole.getName())){
            ex.createCriteria().andEqualTo("name",uRole.getName());
        }
        list =  roleMapper.selectByExample(ex);
        page.setCount(roleMapper.selectCountByExample(ex));
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


}