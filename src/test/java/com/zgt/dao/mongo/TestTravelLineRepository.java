package com.zgt.dao.mongo;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zgt.model.mongo.TravelLinePO;

public class TestTravelLineRepository {
    
    private static TravelLineRepository travelLineRepository;
    
    @BeforeClass
    public static void setUp() {
        ApplicationContext acts = new ClassPathXmlApplicationContext("classpath:/*.xml");

        travelLineRepository = (TravelLineRepository) acts.getBean("travelLineRepository");
    }
    
    @Test
    public void testInsert() {
        
        TravelLinePO travelLinePO = new TravelLinePO();
        travelLinePO.setTitle("tuniu");
        travelLinePO.setCreateDate(new Date());
        travelLineRepository.insert(travelLinePO);
    }

    @Test
    public void testGetTravelLine() {
        ArrayList<TravelLinePO> travelLinePOs = (ArrayList<TravelLinePO>) travelLineRepository.getTravelLine();
        
        for (TravelLinePO travelLinePO : travelLinePOs) {
            System.out.println(travelLinePO.getId());
        }
    }
    
}
