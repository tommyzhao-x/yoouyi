package com.yoouyi.dao.user;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.BaseTestCase;
import com.yoouyi.common.Constants;
import com.yoouyi.model.user.RolePO;
import com.yoouyi.model.user.UserPO;

public class TestUserDAO implements BaseTestCase {

    private static UserDAO userDAO;
    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {

        userDAO = (UserDAO) acts.getBean("userDAO");
        roleDAO = (RoleDAO) acts.getBean("roleDAO");
}

    @Test
    public void testAdd() {
       String userName = "zhaogangtao";

        RolePO role = roleDAO.getRoleByName(Constants.ROLE_SYSTEM_ADMIN);
        
        UserPO user = new UserPO();
        user.setUsername(userName);
        user.setRole(role);

        userDAO.saveUser(user);
    }

    @Test
    public void testGetUserByName() {
        String userName = "zhaogangtao";
        UserPO user = userDAO.getUserByName(userName);
        if (user != null) {
            System.out.println(user.getRole().getName());
            Assert.assertEquals(userName, user.getUsername());
        }
    }
    
    @Test
    public void testUpdateUserLoginIp() {
        String username = "zhaogangtao";
        String remoteAddress = "192.168.1.1";

        userDAO.updateUserLoginIp(username, remoteAddress);
    }
    
    @Test
    public void testPagination() {
        System.out.print(userDAO.getUsers(1));
    }
    
    @Test
    public void testCountUserSize() {
        System.out.println(userDAO.countUsersTotalNum());
    }

}
