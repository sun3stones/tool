package com.lei.tool.mapper;

import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.UUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectGroupMapper extends Mapper<ProjectGroup> {

    List<ProjectGroup> selectByUser(@Param("project") ProjectGroup projectGroup,@Param("user") UUser user);

    Integer selectByUserCount(@Param("project") ProjectGroup projectGroup,@Param("user") UUser user);
}