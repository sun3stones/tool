package com.lei.tool.service;


import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.Page;

import java.util.List;

public interface UserService {

    UUser selectUser(UUser user);

    int getUserCount();

    URole getRole(UUser user);

    List<URole> getRoleList(String roleName);

    Page<URole> getRolePage(Page<URole> page,URole uRole);

    List<UPermission> getPermission(UUser user);

    List<UPermission> getMenu(UUser user);

}
