package com.yoouyi.service.user;

import com.yoouyi.common.Pagination;
import com.yoouyi.model.FavoritePO;
import com.yoouyi.security.CustomUserDetail;

public interface FavoriteService {
    
    public FavoritePO save(FavoritePO favoritePO, CustomUserDetail userDetail);

    public Pagination findAll(Integer pageNum, CustomUserDetail customUserDetail);

}
