package com.tyler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.logging.Filter;

@SpringBootApplication
public class AjaxserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxserverApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registerFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addUrlPatterns("/*");
		bean.setFilter(new CrossFilter());

		return bean;
	}

}
