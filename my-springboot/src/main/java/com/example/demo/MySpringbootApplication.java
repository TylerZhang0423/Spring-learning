package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@ImportResource(locations={"classpath:spring-mvc.xml"})
@EnableAsync

public class MySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringbootApplication.class, args);
	}

}
