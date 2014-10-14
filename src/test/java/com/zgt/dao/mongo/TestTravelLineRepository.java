package com.zgt.dao.mongo;

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
        travelLinePO.setId(2);
        travelLinePO.setTitle("tuniu");
        travelLineRepository.insert(travelLinePO);
    }

}
