package com.lei.tool.service;


import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.Page;

import java.util.List;

public interface UserService {

    UserDto selectUser(UUser user);

    int getUserCount();

    URole getRole(UUser user);

    List<URole> getroleList(String roleName);

    Page<URole> getRolePage(Page<URole> page,URole uRole);

    List<UPermission> getPermission(UUser user);

    List<UPermission> getRolePermission(URole uRole);

    List<UPermission> getMenu(UUser user);

    List<UPermission> getAllMenu();

    List<UPermission> getAllPermission();

    int updateRolePermission(String perIds,Long roleId);

    int insertRole(URole uRole);

    int deleteRole(URole uRole);

    Page<UserDto> getUserPage(Page<UserDto> page,UserDto user);

    List<URole> getInitRole(UUser user);

    String insertUser(UUser user,Long roleId,Long projectId);

    int deleteUser(UUser user);

    int updateUser(UUser user,Long roleId);
}
