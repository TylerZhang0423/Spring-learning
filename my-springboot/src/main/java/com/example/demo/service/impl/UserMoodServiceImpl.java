package com.example.demo.service.impl;

import com.example.demo.model.UserMood;
import com.example.demo.mq.UserMoodProducer;
import com.example.demo.repository.UserMoodRepository;
import com.example.demo.service.UserMoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-18 23:09
 */
@Service
public class UserMoodServiceImpl implements UserMoodService {

    @Resource
    private UserMoodRepository userMoodRepository;

    @Override
    public UserMood save(UserMood userMood) {
        return userMoodRepository.save(userMood);
    }

    //队列
    private static Destination destination = new ActiveMQQueue("user.queue.asyn.save");

    @Resource
    private UserMoodProducer userMoodProducer;
    @Override
    public String asynSave(UserMood userMood){
        //往队列user.queue.asyn.save推送消息，消息内容为说说实体
        userMoodProducer.sendMessage(destination, userMood);
        return "success";
    }
}
