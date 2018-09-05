package com.lei.tool.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by LF on 2017/3/5.
 */
@WebListener("MyListener")
public class MyListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("==========================================监听器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("==========================================监听器销毁");
    }
}