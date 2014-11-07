package com.zgt.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyi.model.UserPO;
import com.youyi.service.admin.UserService;

public class UserServiceTest {

    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        userService = (UserService) acts.getBean("userService");
    }
    
    @Test
    public void testAddUser() {
        UserPO user = new UserPO();
        user.setUsername("admin");
        user.setPassword("admin");
        
        userService.addUser(user);
    }

}
