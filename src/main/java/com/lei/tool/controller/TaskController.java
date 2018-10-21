package com.lei.tool.controller;

import com.lei.tool.dto.TaskDto;
import com.lei.tool.service.ProjectTaskService;
import com.lei.tool.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private ProjectTaskService taskService;

    @RequestMapping("/taskList")
    public String taskList(){
        return "task/taskList";
    }

    @RequestMapping("/taskDataList")
    @ResponseBody
    public Page<TaskDto> taskDataList(Page<TaskDto> page,TaskDto taskDto){
        return taskService.getTaskPage(page,taskDto);
    }
}