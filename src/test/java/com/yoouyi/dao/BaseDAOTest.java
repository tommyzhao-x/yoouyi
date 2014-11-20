package com.yoouyi.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface BaseDAOTest {

    public static final ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");
    // ApplicationContext acts;
    //
    // BaseDAOTest() {
    // acts = new ClassPathXmlApplicationContext("classpath:/*.xml");
    //
    // }
}
