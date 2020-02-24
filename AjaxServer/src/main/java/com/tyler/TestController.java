package com.tyler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-23 16:02
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/get1")
    private ResultBean get1(){
        System.out.println("TestController.get1()");
        return new ResultBean("get1 OK");
    }
}
