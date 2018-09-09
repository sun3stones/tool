package com.lei.tool.mapper;

import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UPermissionMapper extends Mapper<UPermission> {
    List<UPermission> selectPermission(UUser user);

    List<UPermission> selectRolePermission(URole role);

    List<UPermission> selectMenu(UUser user);

    List<UPermission> selectAllMenu();
}