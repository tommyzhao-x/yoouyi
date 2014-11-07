package com.zgt.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyi.dao.admin.RoleDAO;
import com.youyi.dao.admin.UserDAO;
import com.youyi.model.RolePO;
import com.youyi.model.UserPO;

public class UserDAOTest2 {

    private static UserDAO userDAO;
    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        userDAO = (UserDAO) acts.getBean("userDAO");
        roleDAO = (RoleDAO) acts.getBean("roleDAO");
}

    @Test
    public void testAdd() {
       String userName = "zhaogangtao";

        RolePO role = new  RolePO();
        role.setId(1);
        
        UserPO user = new UserPO();
        user.setUsername(userName);
        user.setRole(role);

        userDAO.saveUser(user);
    }

    @Test
    public void testGetUserByName() {
        String userName = "admin";
        UserPO user = userDAO.getUserByName(userName);
        if (user != null) {
            Assert.assertEquals(userName, user.getUsername());
        }
    }
    
    @Test
    public void testUpdateUserLoginIp() {
        String username = "zhaogangtao";
        String remoteAddress = "192.168.1.1";

        userDAO.updateUserLoginIp(username, remoteAddress);
    }

}
