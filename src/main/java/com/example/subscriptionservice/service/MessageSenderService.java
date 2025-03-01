package com.example.subscriptionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendMessage(String queue, String msg) {
        rabbitTemplate.convertAndSend(queue, msg);
    }
}
