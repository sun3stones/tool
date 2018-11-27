package com.lei.tool;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class ActiveMQTest {

    @Test
    public void producer() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test");
        MessageProducer producer = session.createProducer(topic);
        TextMessage message = session.createTextMessage("hello");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void consumer() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test");
        final MessageConsumer consumer = session.createConsumer(topic);
        MessageListener listener = new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println(message);
            }
        };
        while(true){
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
        }
    }
}
