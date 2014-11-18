package com.yoouyi.dao;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yoouyi.dao.admin.RoleDAO;
import com.yoouyi.dao.user.FavoriteDAO;
import com.yoouyi.model.FavoritePO;

public class TestFavoriteDAO {

    private static FavoriteDAO favoriteDAO;

    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        favoriteDAO = (FavoriteDAO) acts.getBean("favoriteDAO");
    }

    @Test
    public void testSave() {
        
        FavoritePO favoritePO = new FavoritePO();
        
        favoritePO.setCreateDate(new Date());
        
        favoriteDAO.save(favoritePO);

    }

}
