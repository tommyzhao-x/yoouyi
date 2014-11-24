package com.yoouyi.service.trip;

import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.security.CustomUserDetail;

public interface RecentService {
    
    public boolean add(RecentPO recentPO, CustomUserDetail user);

}
