package com.yoouyi.service.travel.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yoouyi.common.Pagination;
import com.yoouyi.dao.travel.TravelLineDAO;
import com.yoouyi.model.vo.TravelLineSearchVO;
import com.yoouyi.service.travel.TravelService;

@Service("travelService")
public class TravelServiceImpl implements TravelService {

    private TravelLineDAO travelLineDAO;

    public TravelLineDAO getTravelLineDAO() {
        return travelLineDAO;
    }

    @Resource
    public void setTravelLineDAO(TravelLineDAO travelLineDAO) {
        this.travelLineDAO = travelLineDAO;
    }

    public Pagination getAll(TravelLineSearchVO searchVO) {
        Pagination pagination = Pagination.getInstance();

        pagination.setItems(travelLineDAO.getTravelLine(searchVO));
        pagination.setSize(travelLineDAO.count(searchVO));
        return pagination;
    }

    @Override
    public List<String> getAllTravelPlatforms(String starting, String destination, Date itinerary) {
        return travelLineDAO.getAllTravelPlatForm(starting, destination, itinerary);
    }

    @Override
    public List<String> getAllTravelTimes(String starting, String destination, Date itinerary) {
        return travelLineDAO.getAllTravelTime(starting, destination, itinerary);
    }

}
