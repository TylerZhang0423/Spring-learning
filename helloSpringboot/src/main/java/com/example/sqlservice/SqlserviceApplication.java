package com.example.sqlservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class SqlserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlserviceApplication.class, args);
	}

	/**
	 * 测试api
	 * @return 测试返回字符串
	 */
	@RequestMapping(value = "/")
	public String index() {
		return "fuck you!";
	}
}
