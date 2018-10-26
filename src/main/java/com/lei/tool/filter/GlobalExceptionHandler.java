package com.lei.tool.filter;

import com.lei.tool.controller.BaseController;
import com.lei.tool.entity.UUser;
import com.lei.tool.test.Student;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
class GlobalExceptionHandler extends BaseController {

    @Autowired
    private Student student;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        request.setAttribute("exception", e);
        request.setAttribute("url", request.getRequestURL());
        Subject subject = SecurityUtils.getSubject();
        if(isAjaxRequest(request)){
        }
        UUser user = getUser();
        if (user == null) {
            return "login";
        }else{
            return "error";
        }
    }

    // 判断是否为ajax请求
    public boolean isAjaxRequest(HttpServletRequest request){
        boolean isAjaxRequest = false;
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
}