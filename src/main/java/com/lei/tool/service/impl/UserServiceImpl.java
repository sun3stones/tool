package com.lei.tool.service.impl;

import com.github.pagehelper.PageHelper;
import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.*;
import com.lei.tool.mapper.*;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.Page;
import com.lei.tool.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private ProjectGroupUserMapper projectGroupUserMapper;

    @Override
    public UserDto selectUser(UUser user) {
        UserDto userDto = userMapper.login(user);
        return userDto;
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
        int count = 0;
        if(StringUtils.isEmpty(uRole.getName())){
            list = roleMapper.selectAll();
            count = roleMapper.selectCount(null);
        }else{
            list = roleMapper.select(uRole);
            count = roleMapper.selectCount(uRole);
        }
        page.setCount(count);
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
    public Page<UserDto> getUserPage(Page<UserDto> page, UserDto user) {
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<UserDto> list = userMapper.selectUserList(user);
        int count = userMapper.selectUserCount(user);
        page.setCount(count);
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
    public String insertUser(UserDto userDto) {
        UUser user = new UUser();
        BeanUtils.copyProperties(userDto,user);
        if(userMapper.selectCount(user)>0){
            return "新增用户失败：用户名已存在！";
        }
        user.setPassword(DigestUtils.md5Hex("123456"));
        userMapper.insertSelective(user);
        UUserRole ur = new UUserRole();
        ur.setUid(user.getId());
        ur.setRid(userDto.getRoleId());
        userRoleMapper.insert(ur);
        ProjectGroupUser pgu = new ProjectGroupUser();
        pgu.setGid(userDto.getProjectId());
        pgu.setUid(user.getId());
        projectGroupUserMapper.insertSelective(pgu);
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
    public int updateUser(UserDto userDto) {
        Example exUserRole = new Example(UUserRole.class);
        exUserRole.createCriteria().andEqualTo("uid",userDto.getId());
        UUserRole userRole = new UUserRole();
        userRole.setUid(userDto.getId());
        if(userDto.getRoleId() != null){
            userRole.setRid(userDto.getRoleId());
            userRoleMapper.updateByExampleSelective(userRole,exUserRole);
        }
        UUser user = new UUser();
        BeanUtils.copyProperties(userDto,user);
        return userMapper.updateByPrimaryKeySelective(user);
    }


}