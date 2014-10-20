package com.zgt.service.travel;

import java.util.Date;
import java.util.List;

import com.zgt.common.Pagination;

public interface TravelService {
    public Pagination getAll(Integer pageNum, String starting,
            String destination, Date travelTime);

    public List<String> getAllTravelTimes(String starting, String keyWord,
                                          Date travelTime);

    public List<String> getAllTravelPlatforms(String starting, String keyWord, Date travelTime);
}
