package com.tyler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class AjaxClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxClientApplication.class, args);
	}


}
