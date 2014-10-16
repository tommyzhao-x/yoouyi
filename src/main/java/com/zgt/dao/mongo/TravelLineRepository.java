package com.zgt.dao.mongo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zgt.model.mongo.TravelLinePO;

@Component("travelLineRepository")
public class TravelLineRepository {

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insert(TravelLinePO travelLinePO) {
        mongoTemplate.insert(travelLinePO);
    }
    
    
    public List<TravelLinePO> getTravelLine() {
        return mongoTemplate.findAll(TravelLinePO.class);
    }

}
