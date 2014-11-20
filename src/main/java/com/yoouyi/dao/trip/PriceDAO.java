package com.yoouyi.dao.trip;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.yoouyi.model.trip.PricePO;

@Repository
public class PriceDAO {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<PricePO> findAll() {
        List<PricePO> result = mongoTemplate.findAll(PricePO.class);
        return result;
    }

    public List<PricePO> findAll(List<ObjectId> idList) {

        List<PricePO> result = mongoTemplate.find(Query.query(Criteria.where("tripId").in(idList)), PricePO.class);
        return result;
    }

    public List<PricePO> findAll(List<ObjectId> idList, String tripTime) {
        Query query = Query.query(Criteria.where("tripId").in(idList).and("date").is(tripTime));
        
        query.with(new Sort(Sort.Direction.ASC, "price"));
        
        List<PricePO> result = mongoTemplate.find(query, PricePO.class);
        return result;

    }
    

}
