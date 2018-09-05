package com.lei.tool.mapper;

import com.lei.tool.entity.UPermission;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.MyMapper;

import java.util.List;

public interface UPermissionMapper extends MyMapper<UPermission> {

    List<UPermission> selectPermission(UUser user);

    List<UPermission> selectMenu(UUser user);

}