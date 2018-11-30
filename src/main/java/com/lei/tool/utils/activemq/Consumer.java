/*
package com.lei.tool.utils.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
public class Consumer {
    @JmsListener(destination="active.queue")
    public void readActiveQueue(String message) {
        System.out.println("接受到Queue：" + message);
    }

    @JmsListener(destination="active.topic")
    public void readActiveTopic(String message) {
        System.out.println("接受到topic：" + message);
    }

}

*/
