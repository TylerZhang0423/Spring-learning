package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Helloworld.HelloWorld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld testHelloWorld=(HelloWorld) ac.getBean("testHelloWorld");
		testHelloWorld.show();
	}
}
