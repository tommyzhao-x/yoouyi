package com.yoouyi.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoouyi.common.Pagination;
import com.yoouyi.dao.user.FavoriteDAO;
import com.yoouyi.model.FavoritePO;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.security.CustomUserDetail;
import com.yoouyi.service.user.FavoriteService;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDAO favoriteDAO;

    @Override
    public FavoritePO save(FavoritePO favoritePO, CustomUserDetail userDetail) {

        favoritePO.setUserId(userDetail.getId());
        favoritePO.setCreateDate(new Date());
        
        return favoriteDAO.save(favoritePO);
    }

    @Override
    public Pagination findAll(Integer pageNum, CustomUserDetail customUserDetail) {
        Pagination pagination = Pagination.getInstance();
        pagination.setItems(favoriteDAO.findAll(pageNum, customUserDetail.getId()));
        pagination.setSize(favoriteDAO.count(customUserDetail.getId()));
        return pagination;
    }

    @Override
    public boolean isExist(TripPO trip, CustomUserDetail user) {
        return favoriteDAO.isExist(trip, user);
    }

}
