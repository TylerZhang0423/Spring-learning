package com.tyler;

import com.tyler.dao.UserDOMapper;
import com.tyler.dataobject.UserDO;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.tyler"})
@RestController
@MapperScan("com.tyler.dao")
public class App 
{
    private static Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
        LOGGER.info( "The project started successfully!" );
    }
}
