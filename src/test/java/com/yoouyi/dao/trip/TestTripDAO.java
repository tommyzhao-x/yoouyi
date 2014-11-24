package com.yoouyi.dao.trip;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.common.BaseTestCase;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.model.vo.TripSearchVO;

public class TestTripDAO implements BaseTestCase {
    
    private static TripDAO tripDAO;
    
    @BeforeClass
    public static void setUp() {

        tripDAO = (TripDAO) acts.getBean("tripDAO");
    }
    
    @Test
    public void testInsert() {
        
        TripPO travelLinePO = new TripPO();
        travelLinePO.setTitle("tuniu");
        tripDAO.insert(travelLinePO);
    }

    @Test
    public void testGetTravelLine() {
        TripSearchVO searchItem = new TripSearchVO();
        searchItem.setStarting("上海");
        searchItem.setDestination("华山");
        ArrayList<TripPO> travelLinePOs = (ArrayList<TripPO>) tripDAO.findAll(searchItem);
        System.out.println(travelLinePOs.size());
//        for (TravelInfo travelLinePO : travelLinePOs) {
//            System.out.println(travelLinePO.getId());
//        }
    }
    
    @Test
    public void testGetAllTravelTime() {
        System.out.println(tripDAO.getAllTravelTime(null, null, null));
    }
    
}
