package com.yoouyi.service;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.common.BaseTestCase;
import com.yoouyi.common.Constants;
import com.yoouyi.dao.user.RoleDAO;
import com.yoouyi.model.user.UserPO;
import com.yoouyi.service.user.UserService;

public class UserServiceTest implements BaseTestCase {

    private static UserService userService;
    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {

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
