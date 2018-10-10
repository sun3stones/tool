package com.lei.tool.service;

import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.ProjectTask;
import com.lei.tool.entity.URole;
import com.lei.tool.entity.UUser;
import com.lei.tool.utils.Page;

import java.util.List;
import java.util.Map;

public interface ProjectTaskService {

    Page<ProjectGroup> getProjectPage(Page<ProjectGroup> page,ProjectGroup projectGroup, UUser user);

    List<ProjectGroup> getInitProject(UUser user);

    Map<String,Object> addProject(ProjectGroup projectGroup, UUser uUser);

    int deleteProject(ProjectGroup projectGroup);

    int updateProject(ProjectGroup projectGroup,UUser uUser);

}
