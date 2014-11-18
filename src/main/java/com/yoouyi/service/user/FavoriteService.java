package com.yoouyi.service.user;

import com.yoouyi.model.FavoritePO;
import com.yoouyi.security.CustomUserDetail;

public interface FavoriteService {
    
    public FavoritePO save(FavoritePO favoritePO, CustomUserDetail userDetail);

}
