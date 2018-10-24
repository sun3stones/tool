package com.lei.tool.controller;

import com.lei.tool.dto.TaskDto;
import com.lei.tool.dto.UserDto;
import com.lei.tool.entity.ProjectGroup;
import com.lei.tool.entity.UUser;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private ProjectTaskService taskService;

    @RequestMapping("/taskList")
    public String taskList(HttpServletRequest request){
        UUser user = getUser();
        List<ProjectGroup> projectList = taskService.getInitProject(user);
        request.setAttribute("projectList",projectList);
        return "task/taskList";
    }

    @RequestMapping("/taskDataList")
    @ResponseBody
    public Page<TaskDto> taskDataList(Page<TaskDto> page,TaskDto taskDto){
        UUser user = getUser();
        taskDto.setUid(user.getId());
        return taskService.getTaskPage(page,taskDto);
    }

    @RequestMapping("/taskAdd")
    public String taskAdd(){
        return "task/taskForm";
    }
}
