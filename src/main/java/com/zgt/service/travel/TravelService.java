package com.zgt.service.travel;

import java.util.Date;

import com.zgt.common.Pagination;

public interface TravelService {
    public Pagination getAll(Integer pageNum, String starting,
            String destination, Date travelTime);
}
