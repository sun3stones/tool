package com.lei.tool.service;

import com.lei.tool.entity.*;
import com.lei.tool.utils.Page;

import java.util.List;
import java.util.Map;

public interface ProjectTaskService {

    Page<ProjectGroup> getProjectPage(Page<ProjectGroup> page,ProjectGroup projectGroup, UUser user);

    List<ProjectGroup> getProject(ProjectGroup projectGroup);

    List<ProjectGroup> getInitProject(UUser user);

    Map<String,Object> addProject(ProjectGroup projectGroup, UUser uUser);

    int deleteProject(ProjectGroup projectGroup);

    Map<String,Object> updateProject(ProjectGroup projectGroup,UUser uUser);

    int addProjectUser(ProjectGroupUser projectGroupUser);

    Page<ProjectTask> getTaskPage(Page<ProjectTask> page, ProjectTask projectTask);

    int addTask(ProjectTask projectTask);

    int updateTask(ProjectTask projectTask);

    ProjectTask getTaskById(Long id);
}
