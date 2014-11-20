package com.yoouyi.dao.trip;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yoouyi.dao.BaseDAOTest;
import com.yoouyi.dao.user.FavoriteDAO;
import com.yoouyi.dao.user.RoleDAO;
import com.yoouyi.model.FavoritePO;

public class TestFavoriteDAO implements BaseDAOTest {

    private static FavoriteDAO favoriteDAO;

    @BeforeClass
    public static void setUp() {

        favoriteDAO = (FavoriteDAO) acts.getBean("favoriteDAO");
    }

    @Test
    public void testSave() {
        
        FavoritePO favoritePO = new FavoritePO();
        
        favoritePO.setCreateDate(new Date());
        
        favoriteDAO.save(favoritePO);

    }

}
