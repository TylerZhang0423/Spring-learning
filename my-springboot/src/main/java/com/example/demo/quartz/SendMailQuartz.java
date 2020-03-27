package com.example.demo.quartz;

import com.example.demo.mail.SendJunkMailService;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-03-25 22:12
 */
@Component
@Configurable
@EnableScheduling
//如果不想引入定时器发邮件，将这个类注释掉即可
public class SendMailQuartz {

//    //日志对象
//    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);
//
//    @Resource
//    private SendJunkMailService sendJunkMailService;
//    @Resource
//    private UserService userService;
//
//    //每5秒执行一次
//    @Scheduled(cron = "*/5 * *  * * * ")
//    public void reportCurrentByCron(){
//        List<UserModel> userList = userService.findAll();
//        if (userList == null || userList.size() <= 0) return;
//        //发送邮件
//        sendJunkMailService.sendJunkMail(userList);
//        logger.info("定时器运行了!!!");
//    }

}
