package com.yoouyi.dao.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
    

}
