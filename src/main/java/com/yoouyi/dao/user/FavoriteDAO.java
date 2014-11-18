package com.yoouyi.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoouyi.model.FavoritePO;

@Repository("favoriteDAO")
public class FavoriteDAO {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public FavoritePO save(FavoritePO favoritePO) {
        
        mongoTemplate.upsert(Query.query(Criteria.where("userId").is(favoritePO.getUserId()).and("tripId").is(favoritePO.getTripId())),
                Update.update("createDate", favoritePO.getCreateDate()), FavoritePO.class);
        
        return favoritePO;
    }

}
