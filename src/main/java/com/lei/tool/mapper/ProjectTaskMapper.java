package com.lei.tool.mapper;

import com.lei.tool.dto.TaskDto;
import com.lei.tool.entity.ProjectTask;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectTaskMapper extends Mapper<ProjectTask> {
    List<TaskDto> selectTasks(TaskDto taskDto);

    int selectTasksCount(TaskDto taskDto);
}