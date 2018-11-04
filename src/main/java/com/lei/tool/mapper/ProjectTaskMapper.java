package com.lei.tool.mapper;

import com.lei.tool.entity.ProjectTask;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ProjectTaskMapper extends Mapper<ProjectTask> {
    //任务统计数据查询
    List<Map<String, Object>> taskStatistics(ProjectTask projectTask);
}