package com.lei.tool.mapper;

import com.lei.tool.entity.UUser;
import tk.mybatis.mapper.common.Mapper;

public interface UUserMapper extends Mapper<UUser> {
    Integer getUserCount();

}