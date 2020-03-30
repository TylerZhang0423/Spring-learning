package com.tyler;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user) {
        System.out.println("TestController.postJson()");

        return new ResultBean("postJson " + user.getName());
    }
}
