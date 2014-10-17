package com.zgt.dao.mongo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zgt.model.mongo.TravelInfo;

@Repository("travelLineDAO")
public class TravelLineDAO {

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insert(TravelInfo travelLinePO) {
        mongoTemplate.insert(travelLinePO);
    }
    
    
    public List<TravelInfo> getTravelLine(String starting, String destination, Date travelTime) {
        
        Criteria travelLineCriteria = Criteria.where("destination").is(destination);
        
        
        return mongoTemplate.find(new Query(travelLineCriteria), TravelInfo.class);  
    }

}
