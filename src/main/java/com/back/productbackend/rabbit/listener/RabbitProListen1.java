package com.back.productbackend.rabbit.listener;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
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
        System.out.println("**************");
        System.out.println(JSONObject.parse(new String(body, StandardCharsets.UTF_8)));
        System.out.println("**************");
        System.out.println("Message----->"+ message);
    }
}
