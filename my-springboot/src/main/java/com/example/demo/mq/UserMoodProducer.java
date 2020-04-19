package com.example.demo.mq;

import com.example.demo.model.UserMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-19 11:35
 */
@Service
public class UserMoodProducer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final UserMood userMood) {
        jmsMessagingTemplate.convertAndSend(destination, userMood);
    }
}
