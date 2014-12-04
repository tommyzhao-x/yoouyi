package com.yoouyi.service.trip;

import org.junit.BeforeClass;
import org.junit.Test;

import com.yoouyi.common.BaseTestCase;
import com.yoouyi.common.Pagination;
import com.yoouyi.model.vo.TripSearchVO;

public class TestTripService implements BaseTestCase{

    private static TripService tripService;
    
    @BeforeClass
    public static void setUp() {
        tripService = (TripService) acts.getBean("tripService");
    }
    
    @Test
    public void testFindAll() {
        long start = System.currentTimeMillis();
        TripSearchVO searchVO = new TripSearchVO();
        searchVO.setStarting("上海");
        searchVO.setDestination("北京");
        searchVO.setPageNum(1);
        Pagination pagination = tripService.findAll(searchVO);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(pagination.getItems().size());
    }
}
