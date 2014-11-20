package com.yoouyi.dao.trip;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.yoouyi.common.Constants;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.model.vo.TripSearchVO;

@Repository("tripDAO")
public class TripDAO {

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insert(TripPO travelLinePO) {
        mongoTemplate.insert(travelLinePO);
    }
    
    
    public List<TripPO> getTravelLine(TripSearchVO searchVO) {
        
        Query query = createQuery(searchVO);
        
        if (searchVO.getPageNum() != null) {
            query.skip((searchVO.getPageNum() - 1 ) * Constants.PAGE_SIZE);
            query.limit(Constants.PAGE_SIZE);
        }
        
        if (searchVO.isOrder()) {
            query.with(new Sort(Sort.Direction.DESC, "price"));
        } else {
            query.with(new Sort(Sort.Direction.ASC, "price"));
        }
        
        return mongoTemplate.find(query, TripPO.class);  
    }

    private Query createQuery(TripSearchVO searchVO) {
        Criteria travelLineCriteria = Criteria.where("starting").is(searchVO.getStarting())
                .and("destination").is(searchVO.getDestination());
        
        if (StringUtils.isNotBlank(searchVO.getPlatform())) {
            travelLineCriteria.and("platform").is(searchVO.getPlatform());
        }
        
        if (StringUtils.isNotBlank(searchVO.getItinerary())) {
            travelLineCriteria.and("port").is(searchVO.getItinerary());
        }
        
        Query query = new Query(travelLineCriteria);
        
        return query;
    }

    public int count(TripSearchVO searchVO) {
        Query query = createQuery(searchVO);
        return (int) mongoTemplate.count(query, TripPO.class);
    }
    
    public List<String> getAllTravelTime(String starting, String destination, Date itinerary) {
        BasicDBObject whereQuery = createMetaDateQuery(starting, destination, itinerary);
        
        DBCollection query= mongoTemplate.getCollection(mongoTemplate.getCollectionName(TripPO.class));
        List<String> result = query.distinct("port", whereQuery);
        return result;
    }

    public List<String> getAllTravelPlatForm(String starting, String destination, Date itinerary) {
        BasicDBObject whereQuery = createMetaDateQuery(starting, destination, itinerary);

        DBCollection query= mongoTemplate.getCollection(mongoTemplate.getCollectionName(TripPO.class));
        List<String> result = query.distinct("platform", whereQuery);
        return result;
    }

    private BasicDBObject createMetaDateQuery(String starting, String destination, Date itinerary) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("starting", starting);
        whereQuery.put("destination", destination);
        
        return whereQuery;
    }

}
