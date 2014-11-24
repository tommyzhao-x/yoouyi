package com.yoouyi.service.trip.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoouyi.common.Pagination;
import com.yoouyi.dao.trip.TripDAO;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.model.vo.TripSearchVO;
import com.yoouyi.service.trip.TripService;

@Service("tripService")
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDAO tripDAO;

    public Pagination findAll(TripSearchVO searchVO) {
        Pagination pagination = Pagination.getInstance();

        pagination.setItems(tripDAO.findAll(searchVO));
        pagination.setSize(tripDAO.count(searchVO));
        return pagination;
    }

    @Override
    public List<String> getAllTravelPlatforms(String starting, String destination, Date itinerary) {
        return tripDAO.getAllTravelPlatForm(starting, destination, itinerary);
    }

    @Override
    public List<String> getAllTravelTimes(String starting, String destination, Date itinerary) {
        return tripDAO.getAllTravelTime(starting, destination, itinerary);
    }

    @Override
    public void updateViewedTimes(TripPO trip) {
        tripDAO.update(trip);
    }

}
