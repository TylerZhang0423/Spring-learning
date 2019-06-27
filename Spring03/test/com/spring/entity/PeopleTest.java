package com.spring.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void test1() {
        People people=(People)ac.getBean("people1");
        System.out.println(people);
    }
}

//在idea上使用junit4，需要使用junit4.12版本，并且需要导入harmcrest的jar包