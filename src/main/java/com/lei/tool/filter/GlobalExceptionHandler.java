package com.lei.tool.filter;

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

@ControllerAdvice
class GlobalExceptionHandler {

    @Autowired
    private Student student;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest reqest, Exception e) throws Exception {
        reqest.setAttribute("exception", e);
        reqest.setAttribute("url", reqest.getRequestURL());
        Subject subject = SecurityUtils.getSubject();
        UUser user = (UUser) subject.getPrincipal();
        if (user == null) {
            return "login";
        }else{
            return "index";
        }
    }
}