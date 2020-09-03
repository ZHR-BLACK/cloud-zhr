package com.haly.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Sender
 * @Date 2020-09-03 11:27
 * @description mq消息发送,生产者
 **/
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public String send() {
        String content = "hello" + new Date();
        System.out.println("Sender:" + content);
        this.rabbitmqTemplate.convertAndSend("hello", content);
        return "send_success";
    }

    public String sendMessage(Message message) {
        System.out.println("message==================" + message);
        this.rabbitmqTemplate.convertAndSend("exchange.message","routing.key.message", message);
        return "send_success";
    }
}
