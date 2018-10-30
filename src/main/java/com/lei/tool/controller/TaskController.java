package com.lei.tool.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.ProjectTask;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.service.UserService;
import com.lei.tool.utils.ObjectUtils;
import com.lei.tool.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private ProjectTaskService taskService;
    @Autowired
    private UserService userService;

    @RequestMapping("/taskList")
    public String taskList(HttpServletRequest request){
        UUser user = getUser();
        List<ProjectGroup> projectList = taskService.getInitProject(user);
        request.setAttribute("projectList",projectList);
        return "task/taskList";
    }

    @RequestMapping("/taskDataList")
    @ResponseBody
    public Page<ProjectTask> taskDataList(Page<ProjectTask> page, ProjectTask projectTask) throws IllegalAccessException {
        UUser user = getUser();
        projectTask.setUserName(user.getUserName());
        projectTask = ObjectUtils.setNullValue(projectTask);
        return taskService.getTaskPage(page,projectTask);
    }

    @RequestMapping("/taskAdd")
    public String taskAdd(HttpServletRequest request,Long projectId){
        List<UserDto> userList = userService.getUserList(getUserDto());
        request.setAttribute("userList",userList);
        request.setAttribute("projectId",projectId);
        return "task/taskForm";
    }

    @RequestMapping(value = {"/addTaskSave","/updateTaskSave"})
    @ResponseBody
    public Map<String,Object> taskAddSave(HttpServletRequest request, ProjectTask projectTask){
        Map<String,Object> map = new HashMap<>();
        if(projectTask.getId() == null){//新增
            projectTask.setUpdateTime(new Date());
            UUser user = getUser();
            projectTask.setCreateName(user.getUserName());
            taskService.addTask(projectTask);
            map.put("msg","新增任务成功");
        }else{//修改
            projectTask.setUpdateTime(new Date());
            taskService.updateTask(projectTask);
            map.put("msg","修改任务成功");
        }
        map.put("errcode",0);
        return map;
    }

    @RequestMapping("taskDetail")
    public String taskDetail(HttpServletRequest request,Long id){
        ProjectTask projectTask = taskService.getTaskById(id);
        List<UserDto> userList = userService.getUserList(getUserDto());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = df.format(projectTask.getStartDate());
        String endDate = df.format(projectTask.getEndDate());
        String[] images = projectTask.getImages().split(";");
        String[] files = projectTask.getFiles().split(";");
        request.setAttribute("images",images);
        request.setAttribute("files",files);
        request.setAttribute("userList",userList);
        request.setAttribute("task",projectTask);
        request.setAttribute("startDate",startDate);
        request.setAttribute("endDate",endDate);
        return "task/taskForm";
    }
}
