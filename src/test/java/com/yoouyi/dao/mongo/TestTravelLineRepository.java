package com.yoouyi.dao.mongo;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yoouyi.dao.travel.TravelLineDAO;
import com.yoouyi.model.mongo.TravelInfo;

public class TestTravelLineRepository {
    
    private static TravelLineDAO travelLineDAO;
    
    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        travelLineDAO = (TravelLineDAO) acts.getBean("travelLineDAO");
    }
    
    @Test
    public void testInsert() {
        
        TravelInfo travelLinePO = new TravelInfo();
        travelLinePO.setTitle("tuniu");
        travelLineDAO.insert(travelLinePO);
    }

    @Test
    public void testGetTravelLine() {
        ArrayList<TravelInfo> travelLinePOs = (ArrayList<TravelInfo>) travelLineDAO.getTravelLine(null);
        System.out.println(travelLinePOs.size());
//        for (TravelInfo travelLinePO : travelLinePOs) {
//            System.out.println(travelLinePO.getId());
//        }
    }
    
    @Test
    public void testGetAllTravelTime() {
        System.out.println(travelLineDAO.getAllTravelTime(null, null, null));
    }
    
}
