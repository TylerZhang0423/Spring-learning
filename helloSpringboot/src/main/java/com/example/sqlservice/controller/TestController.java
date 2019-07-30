package com.example.sqlservice.controller;

import com.example.sqlservice.entity.Users;
import com.example.sqlservice.services.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    @Autowired
    private SqlService userService;


    /**
     * 测试用
     * //@param name 传入参数name
     * //@param password 传入参数password
     * //@return 插入结果，失败or成功+id
     */
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String insertUser(@RequestParam("name") String name) {

        Users user = new Users();
        //String id = UUID.randomUUID().toString().toLowerCase();
        //int id =1;
        Integer id;
        id = 4;
        user.setId(id);
        user.setUsername(name);
        try {
            userService.insert(user);
            return "插入成功，其id为" + id;
        } catch (Exception e) {
            return "插入失败!！";
        }

    }
}