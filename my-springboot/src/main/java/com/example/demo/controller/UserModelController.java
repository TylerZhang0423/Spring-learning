package com.example.demo.controller;


import com.example.demo.error.BusinessException;
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

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<UserModel> userModelList = userService.findAll();
        model.addAttribute("users", userModelList);
        throw new BusinessException("业务异常");
    }

    @RequestMapping("/findByNameAndPasswordRetry")
    public String findByNameAndPasswordRetry(Model model) {
        UserModel userModel = userService.findByNameAndPasswordRetry("tyelr", "1234567");
        model.addAttribute("users", userModel);
        return "success";
    }

}
