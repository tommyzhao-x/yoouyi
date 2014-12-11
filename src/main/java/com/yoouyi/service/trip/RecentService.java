package com.yoouyi.service.trip;

import java.util.List;

import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.security.CustomUserDetail;

public interface RecentService {
    
    public boolean add(RecentPO recentPO, CustomUserDetail user);

    public List<RecentPO> findAll(CustomUserDetail user);

}
