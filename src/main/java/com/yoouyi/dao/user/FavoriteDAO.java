package com.yoouyi.dao.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoouyi.common.Constants;
import com.yoouyi.model.FavoritePO;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.security.CustomUserDetail;

@Repository("favoriteDAO")
public class FavoriteDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public FavoritePO save(FavoritePO favoritePO) {

        mongoTemplate.upsert(Query.query(Criteria.where("userId").is(favoritePO.getUserId()).and("trip").is(favoritePO.getTrip())),
                Update.update("createDate", favoritePO.getCreateDate()), FavoritePO.class);

        return favoritePO;
    }

    public int count(ObjectId userId) {
        Long result = mongoTemplate.count(Query.query(Criteria.where("userId").is(userId)), FavoritePO.class);
        return result.intValue();
    }

    public List<FavoritePO> findAll(Integer pageNum, ObjectId userId) {
        Criteria criteria = Criteria.where("userId").is(userId);

        Query query = new Query(criteria);

        if (pageNum != null) {
            query.skip((pageNum - 1) * Constants.PAGE_SIZE);
            query.limit(Constants.PAGE_SIZE);
        }

        query.with(new Sort(Sort.Direction.DESC, "createDate"));
        List<FavoritePO> list = mongoTemplate.find(query, FavoritePO.class);
        return list;
    }

    public boolean isExist(TripPO trip, CustomUserDetail user) {
        TripPO tripPO = mongoTemplate.findOne(Query.query(Criteria.where("userId").is(user.getId()).and("trip").is(trip)), TripPO.class);
        return tripPO != null;
    }

}
