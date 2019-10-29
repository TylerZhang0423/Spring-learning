package com.ecommerceproject;

import com.ecommerceproject.dao.UserDOMapper;
import com.ecommerceproject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.ecommerceproject"})
@RestController
@MapperScan("com.ecommerceproject.dao")
public class App 
{

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){

        return "This is homepage!";
    }

    public static void main( String[] args ) {
        System.out.println( "Start the project." );
        SpringApplication.run(App.class, args);
    }
}
