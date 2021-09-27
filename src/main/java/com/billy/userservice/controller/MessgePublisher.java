package com.billy.userservice.controller;


import com.billy.userservice.config.CustomMessage;
import com.billy.userservice.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessgePublisher {

    @Autowired
 private RabbitTemplate rabbitTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message ){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }
}
