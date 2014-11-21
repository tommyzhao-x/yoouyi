package com.yoouyi.service.trip;

import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.security.CustomUserDetail;

public interface RecentService {
    
    public void add(RecentPO recentPO, CustomUserDetail user);

}
