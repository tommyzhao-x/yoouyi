package com.yoouyi.service.trip;

import java.util.Date;
import java.util.List;

import com.yoouyi.common.Pagination;
import com.yoouyi.model.vo.TravelLineSearchVO;

public interface TripService {
    public Pagination getAll(TravelLineSearchVO searchVO);

    public List<String> getAllTravelTimes(String starting, String keyWord, Date departure);

    public List<String> getAllTravelPlatforms(String starting, String keyWord, Date departure);
}
