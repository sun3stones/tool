package com.lei.tool.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.ProjectGroupUser;
import com.lei.tool.entity.ProjectTask;
import com.lei.tool.entity.UUser;
import com.lei.tool.mapper.ProjectGroupMapper;
import com.lei.tool.mapper.ProjectGroupUserMapper;
import com.lei.tool.mapper.ProjectTaskMapper;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

    @Autowired
    private ProjectGroupMapper projectGroupMapper;
    @Autowired
    private ProjectGroupUserMapper projectGroupUserMapper;
    @Autowired
    private ProjectTaskMapper projectTaskMapper;

    @Override
    public Page<ProjectGroup> getProjectPage(Page<ProjectGroup> page,ProjectGroup projectGroup, UUser user) {
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<ProjectGroup> list =  projectGroupMapper.selectByUser(projectGroup,user);
        PageInfo<ProjectGroup> pageInfo = new PageInfo<ProjectGroup>(list);
        //Integer count = projectGroupMapper.selectByUserCount(projectGroup,user);
        page.setCount((int)pageInfo.getTotal());
        page.setData(list);
        page.setCode(0);
        page.setMsg("成功");
        return page;
    }

    @Override
    public List<ProjectGroup> getProject(ProjectGroup projectGroup) {
        return  projectGroupMapper.select(projectGroup);
    }

    @Override
    public List<ProjectGroup> getInitProject(UUser user) {
        if(user == null){
            return projectGroupMapper.selectAll();
        }else{
            return projectGroupMapper.selectByUser(null,user);
        }

    }

    @Override
    public Map<String,Object> addProject(ProjectGroup projectGroup, UUser uUser) {
        Map<String,Object> map = new HashMap<>();
        Example ex = new Example(ProjectGroup.class);
        ex.createCriteria().andEqualTo("projectNo",projectGroup.getProjectNo());
        if(projectGroupMapper.selectByExample(ex).size()>0){
            map.put("errcode",1);
            map.put("msg","该项目编号已存在!");
            return map;
        }
        projectGroupMapper.insertSelective(projectGroup);//添加项目
        ProjectGroupUser projectGroupUser = new ProjectGroupUser();
        projectGroupUser.setIsAdmin(1);//设置新增用户为管理员
        projectGroupUser.setUid(uUser.getId());
        projectGroupUser.setGid(projectGroup.getId());
        projectGroupUserMapper.insert(projectGroupUser);
        map.put("errcode",0 );
        map.put("msg","新增项目组成功!");
        return map;
    }

    @Override
    public int deleteProject(ProjectGroup projectGroup) {
        return 0;
    }

    @Override
    public Map<String,Object> updateProject(ProjectGroup projectGroup,UUser uUser) {
        Map<String,Object> map = new HashMap<>();
        Example ex = new Example(ProjectGroup.class);
        ex.createCriteria().andEqualTo("projectNo",projectGroup.getProjectNo());
        projectGroupMapper.updateByPrimaryKeySelective(projectGroup);
        map.put("errcode",0);
        map.put("msg","修改项目组成功!");
        return map;
    }

    @Override
    public int addProjectUser(ProjectGroupUser projectGroupUser) {
        return  projectGroupUserMapper.insertSelective(projectGroupUser);
    }

    @Override
    public Page<ProjectTask> getTaskPage(Page<ProjectTask> page, ProjectTask projectTask) {
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<ProjectTask> list = projectTaskMapper.select(projectTask);
        PageInfo<ProjectTask> pageInfo = new PageInfo<ProjectTask>(list);
        page.setData(list);
        page.setCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public int addTask(ProjectTask projectTask) {
        ProjectGroup project = projectGroupMapper.selectByPrimaryKey(projectTask.getPid());
        //获取taskNo
        ProjectTask pt = new ProjectTask();
        pt.setPid(projectTask.getPid());
        int num = projectTaskMapper.selectCount(pt);
        String taskNo = project.getProjectNo()+"-"+String.format("%04d", num+1);
        projectTask.setTaskNo(taskNo);
        return projectTaskMapper.insertSelective(projectTask);
    }

    @Override
    public int updateTask(ProjectTask projectTask) {
        return projectTaskMapper.updateByPrimaryKeySelective(projectTask);
    }

    @Override
    public ProjectTask getTaskById(Long id) {
        return projectTaskMapper.selectByPrimaryKey(id);
    }
}
