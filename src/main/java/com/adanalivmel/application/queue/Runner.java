package com.adanalivmel.application.queue;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Runner {
	@Autowired
    private RabbitTemplate rabbitTemplate;
    
	@Autowired
    private Receiver receiver;

    public void sendMessage(String message) throws InterruptedException {
        this.rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", message);
        this.receiver.getLatch().await(10000L, TimeUnit.MILLISECONDS);
    }
}
