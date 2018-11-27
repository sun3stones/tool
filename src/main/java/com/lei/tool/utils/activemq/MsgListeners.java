package com.lei.tool.utils.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class MsgListeners {

    /**
     * 点对点
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("active.queue");
    }

    /**
     * 发布/订阅
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("active.topic");
    }
}