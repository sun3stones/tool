package com.lei.tool.mapper;

import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import tk.mybatis.mapper.common.Mapper;

public interface URoleMapper extends Mapper<URole> {
    URole selectRole(UUser user);
}