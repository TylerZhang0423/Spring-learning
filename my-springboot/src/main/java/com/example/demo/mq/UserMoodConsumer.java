package com.example.demo.mq;

import com.example.demo.model.UserMood;
import com.example.demo.service.UserMoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-19 12:01
 */

@Component
public class UserMoodConsumer {
    @JmsListener(destination = "user.queue")
    public void receiveQueue(String text) {
        System.out.println("用户发表说说【" + text + "】成功");
    }

    @Resource
    private UserMoodService userMoodService;

    @JmsListener(destination = "user.queue.asyn.save")
    public void receiveQueue(UserMood userMood){
        userMoodService.save(userMood);
    }
}
