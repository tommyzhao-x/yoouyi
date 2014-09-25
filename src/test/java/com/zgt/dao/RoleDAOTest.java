package com.zgt.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgt.common.Constants;
import com.zgt.model.RolePO;

public class RoleDAOTest {

    private static RoleDAO roleDAO;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext(
                "applicationContext-config.xml");

        roleDAO = (RoleDAO) acts.getBean("roleDAO");
    }

    @Test
    public void testAdd() {

        RolePO role = new RolePO();
        role.setName("admin");

        roleDAO.addRole(role);
    }

    @Test
    public void testGetRoleById() {
        RolePO role = roleDAO.getRoleById(1);
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
        boolean success = roleDAO.deleteRole(2);
        Assert.assertTrue(success);
    }

}
