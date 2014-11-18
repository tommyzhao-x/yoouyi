package com.yoouyi.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoouyi.dao.user.FavoriteDAO;
import com.yoouyi.model.FavoritePO;
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

}
