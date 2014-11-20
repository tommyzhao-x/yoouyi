package com.yoouyi.dao.trip;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.dao.BaseDAOTest;
import com.yoouyi.model.trip.TripPO;

public class TestTripDAO implements BaseDAOTest {
    
    private static TripDAO travelLineDAO;
    
    @BeforeClass
    public static void setUp() {

        travelLineDAO = (TripDAO) acts.getBean("travelLineDAO");
    }
    
    @Test
    public void testInsert() {
        
        TripPO travelLinePO = new TripPO();
        travelLinePO.setTitle("tuniu");
        travelLineDAO.insert(travelLinePO);
    }

    @Test
    public void testGetTravelLine() {
        ArrayList<TripPO> travelLinePOs = (ArrayList<TripPO>) travelLineDAO.getTravelLine(null);
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
