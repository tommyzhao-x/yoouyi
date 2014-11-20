package com.yoouyi.dao.trip;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.dao.BaseDAOTest;
import com.yoouyi.model.trip.PricePO;

public class TestPriceDAO implements BaseDAOTest {

    private static PriceDAO priceDAO;
    
    @BeforeClass
    public static void setUp() {
        priceDAO = (PriceDAO) acts.getBean("priceDAO");
    }
    
    @Test
    public void testFindAll() {
        List<PricePO> list = priceDAO.findAll();
        System.out.println(list.size());
    }
    

}
