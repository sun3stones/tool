package com.lei.tool.mapper;

import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.MyMapper;


public interface URoleMapper extends MyMapper<URole> {

    URole selectRole(UUser user);
}