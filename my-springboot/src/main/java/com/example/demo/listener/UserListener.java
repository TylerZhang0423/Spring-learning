package com.example.demo.listener;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;



@WebListener
public class UserListener implements ServletContextListener {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserService userService;
    private static final String ALL_USER = "ALL_USER_LIST";

    Logger logger = LogManager.getLogger(this.getClass());


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //查询数据库所有用户
        List<UserModel> userList = userService.findAll();

        //清除缓存中的用户数据
        redisTemplate.delete(ALL_USER);

        //将数据存放到redis中
        redisTemplate.opsForList().leftPushAll(ALL_USER, userList);

        List<UserModel> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        //System.out.println("缓存中目前的用户数有：" + queryUserList.size() + " 人");


        //System.out.println("ServletContext 上下文初始化");

        logger.info("ServletContext 上下文初始化");
        logger.info("缓存中目前的用户数有：" + queryUserList.size() + " 人");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //System.out.println("ServletContext 上下文销毁");
        logger.info("ServletContext 上下文销毁");
    }
}
