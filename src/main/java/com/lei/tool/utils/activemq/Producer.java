/*
package com.lei.tool.utils.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    */
/*
     * 消息生产者
     *//*

    public void sendmsg(String msg) {
        // 指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    public void send(String msg) {
        // 指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }

}*/
