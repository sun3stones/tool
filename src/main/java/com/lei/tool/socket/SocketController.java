package com.lei.tool.socket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/socket")
public class SocketController {

	@RequestMapping(value = "/index")
	@ResponseBody
	public ModelAndView index(ModelAndView view)
	{
		//设置jsp名字
		view.setViewName("index");

		//传递数据
		view.addObject("name","张三");

		return view;
	}

}