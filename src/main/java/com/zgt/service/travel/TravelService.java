package com.zgt.service.travel;

import java.util.Date;
import java.util.List;

import com.zgt.common.Pagination;
import com.zgt.model.vo.TravelLineSearchVO;

public interface TravelService {
    public Pagination getAll(TravelLineSearchVO searchVO);

    public List<String> getAllTravelTimes(String starting, String keyWord, Date departure);

    public List<String> getAllTravelPlatforms(String starting, String keyWord, Date departure);
}
