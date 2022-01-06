package com.back.productbackend.rabbit.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author sunke
 * @DATE 2022/1/6
 **/
@Component
public class RabbitProListen1 {

    @RabbitListener(queues = "pro_test_first",concurrency = "10")
    public void receive(Message message){
        byte[] body = message.getBody();
        System.out.println(body);
        System.out.println("Message----->"+ message);
    }
}
