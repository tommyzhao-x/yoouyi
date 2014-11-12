package com.yoouyi.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yoouyi.common.Constants;
import com.yoouyi.dao.admin.RoleDAO;
import com.yoouyi.model.UserPO;
import com.yoouyi.service.admin.UserService;

public class UserServiceTest {

    private static UserService userService;
    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        userService = (UserService) acts.getBean("userService");
        roleDAO = (RoleDAO) acts.getBean("roleDAO");

    }
    
    @Test
    public void testAddUser() {
        UserPO user = new UserPO();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRole(roleDAO.getRoleByName(Constants.ROLE_SYSTEM_USER));
        userService.addUser(user);
    }

}
