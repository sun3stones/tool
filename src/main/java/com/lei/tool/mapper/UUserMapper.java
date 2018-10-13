package com.lei.tool.mapper;

import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.UUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UUserMapper extends Mapper<UUser> {

    UserDto login(UUser uUser);

    List<UserDto> selectUserList(UserDto uUser);
    int selectUserCount(UserDto uUser);

    int getUserCount();
}