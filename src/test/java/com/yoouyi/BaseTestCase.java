package com.yoouyi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface BaseTestCase {

    public static final ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");
}
