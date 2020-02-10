package com.example.demo.controller;


import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userModel")
public class UserModelController {
    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public String test(Model model) {
        //查询数据库所有对象
        List<UserModel> userModelList = userService.findAll();
        model.addAttribute("users", userModelList);
        return "userModel";
    }
}
