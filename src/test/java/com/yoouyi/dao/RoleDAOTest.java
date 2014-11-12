package com.yoouyi.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yoouyi.common.Constants;
import com.yoouyi.dao.admin.RoleDAO;
import com.yoouyi.model.RolePO;

public class RoleDAOTest {

    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        roleDAO = (RoleDAO) acts.getBean("roleDAO");
    }

    @Test
    public void testAdd() {

        RolePO role = new RolePO();
        role.setName(Constants.ROLE_SYSTEM_USER);

        roleDAO.addRole(role);
    }

    @Test
    public void testGetRoleById() {
        RolePO role = roleDAO.getRoleByName(Constants.ROLE_SYSTEM_USER);
        System.out.println(role.getName());
    }
    
    @Test
    public void testGetRoleByPageNum() {
        List<RolePO> roles = roleDAO.getRoles(1);
        Assert.assertEquals(Constants.PAGE_SIZE, roles.size());
    }
    
    @Test
    public void testGetRoleTotalNum() {
        int totalNum = roleDAO.getRolesTotalNum();
        
        System.out.println(totalNum);
    }
    
    @Test
    public void testDeleteRole() {
        ObjectId id = new ObjectId("0");
        boolean success = roleDAO.deleteRole(id);
        Assert.assertTrue(success);
    }

}
