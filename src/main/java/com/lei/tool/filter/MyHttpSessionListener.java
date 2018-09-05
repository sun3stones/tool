package com.lei.tool.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by LF on 2017/4/17.
 */
public class MyHttpSessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("==========session创建");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("==========session销毁");

    }
}