package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.people.*;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext ac= new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		People people=(People) ac.getBean("people");
		System.out.println(people);
	}
}
