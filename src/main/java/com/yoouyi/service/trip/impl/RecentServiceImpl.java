package com.yoouyi.service.trip.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoouyi.dao.trip.RecentDAO;
import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.security.CustomUserDetail;
import com.yoouyi.service.trip.RecentService;

@Service("recentService")
public class RecentServiceImpl implements RecentService {

    @Autowired
    private RecentDAO recentDAO;
    
    @Override
    public void add(RecentPO recentPO, CustomUserDetail user) {

        recentPO.setUserId(user.getId());
        recentPO.setCreateDate(new Date());
        
        recentDAO.save(recentPO);
    }

}
