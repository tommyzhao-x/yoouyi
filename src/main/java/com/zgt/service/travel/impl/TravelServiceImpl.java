package com.zgt.service.travel.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zgt.common.Pagination;
import com.zgt.dao.travel.TravelLineDAO;
import com.zgt.service.travel.TravelService;

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

    public Pagination getAll(Integer pageNum, String starting, String destination, Date travelTime) {
        Pagination pagination = Pagination.getInstance();

        pagination.setItems(travelLineDAO.getTravelLine(pageNum, starting, destination, travelTime));
        pagination.setSize(travelLineDAO.count(destination));
        return pagination;
    }

    @Override
    public List<String> getAllTravelPlatforms(String starting, String destination, Date travelTime) {
        return travelLineDAO.getAllTravelPlatForm(destination);
    }

    @Override
    public List<String> getAllTravelTimes(String starting, String destination, Date travelTime) {
        return travelLineDAO.getAllTravelTime(destination);
    }

}
