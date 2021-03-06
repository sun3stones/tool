package com.lei.tool.service;


import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.Page;

import java.util.List;

public interface UserService {

    UserDto selectUser(UUser user);

    UUser getUser(UUser user);

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

    List<UserDto> getUserList(UserDto user);

    Page<UserDto> getUserPage(Page<UserDto> page,UserDto user);

    List<URole> getInitRole(UUser user);

    String insertUser(UserDto userDto);

    int deleteUser(UUser user);

    int updateUser(UserDto userDto);
}
