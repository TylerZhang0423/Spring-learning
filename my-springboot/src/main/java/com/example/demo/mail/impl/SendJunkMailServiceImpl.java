package com.example.demo.mail.impl;

import com.example.demo.mail.SendJunkMailService;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-03-25 21:59
 */
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {

    @Autowired
    JavaMailSender mailSender;
    @Resource
    private UserService userService;
    @Value("${spring.mail.username}")
    private String from;
    static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

    @Override
    public boolean sendJunkMail(List<UserModel> userModelList) {

        try{
            if(userModelList == null || userModelList.size() <= 0 ) return Boolean.FALSE;
            for(UserModel userModel: userModelList){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setSubject("地瓜今日特卖");
                message.setTo("1732944@tongji.edu.cn");
                message.setText(userModel.getName() + " ,你知道么？厦门地瓜今日特卖，一斤只要9元");
                this.mailSender.send(mimeMessage);
            }
        }catch(Exception ex){
            logger.error("sendJunkMail error and ayUser=%s", userModelList, ex);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

