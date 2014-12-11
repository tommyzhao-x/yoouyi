package com.yoouyi.dao.trip;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoouyi.model.trip.RecentPO;

@Repository
public class RecentDAO {

    @Autowired
    private MongoTemplate mongoTemplate;
    
   
    public RecentPO findOne(ObjectId id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), RecentPO.class);
    }


    public RecentPO save(RecentPO recentVO) {
        mongoTemplate.upsert(Query.query(Criteria.where("userId").is(recentVO.getUserId()).and("trip").is(recentVO.getTrip())),
                Update.update("createDate", recentVO.getCreateDate()), RecentPO.class);
        
        return recentVO;
    }


    public List<RecentPO> findAll(String userId) {
        Query query = Query.query(Criteria.where("userId").is(userId)).limit(10);
        
        query.with(new Sort(Sort.Direction.DESC, "createDate"));
        
        return mongoTemplate.find(query, RecentPO.class);
    }

}
