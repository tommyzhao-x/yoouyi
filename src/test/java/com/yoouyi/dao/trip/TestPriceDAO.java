package com.yoouyi.dao.trip;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.BaseTestCase;
import com.yoouyi.model.trip.PricePO;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.model.vo.TripSearchVO;

public class TestPriceDAO implements BaseTestCase {

    private static PriceDAO priceDAO;
    private static TripDAO tripDAO;

    @BeforeClass
    public static void setUp() {
        priceDAO = (PriceDAO) acts.getBean("priceDAO");
        tripDAO = (TripDAO) acts.getBean("tripDAO");
    }

    @Test
    public void testFindAll() {
        
        long start = System.currentTimeMillis();
        
        TripSearchVO searchItem = new TripSearchVO();
        searchItem.setStarting("上海");
        searchItem.setDestination("华山");
        ArrayList<TripPO> travelLinePOs = (ArrayList<TripPO>) tripDAO.findAll(searchItem);
        System.out.println(travelLinePOs.size());

        System.out.println(System.currentTimeMillis() - start);
        List<ObjectId> idList = new ArrayList<ObjectId>();
        
        for (TripPO tripPO : travelLinePOs) {
            idList.add(tripPO.getId());
        }

        
        Long tripTime = 1416499200000L;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String time = dateFormat.format(new Date(tripTime));
        
        System.out.println(time);
        
        List<PricePO> pricesList = priceDAO.findAll(idList, time);
        for (PricePO pricePO : pricesList) {
            
            System.out.println(pricePO.getPrice());
        }
        
        System.out.println(pricesList.size());

        System.out.println(System.currentTimeMillis() - start);
    }

}
