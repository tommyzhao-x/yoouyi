package com.yoouyi.dao.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.yoouyi.common.Constants;
import com.yoouyi.model.UserPO;

@Component("userDAO")
public class UserDAO {

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public UserPO getUserByName(String userName) {
        Criteria criteria = Criteria.where("username").is(userName);
        Query query = new Query(criteria);
        UserPO user = (UserPO) mongoTemplate.findOne(query, UserPO.class);
        return user;
    }

    public boolean saveUser(UserPO user) {
        mongoTemplate.save(user);
        return true;
    }

    public int countUsersTotalNum() {

        Long result = mongoTemplate.count(null, UserPO.class);

        return result.intValue();
    }

    public List<UserPO> getUsers(Integer pageNum) {
        Query query = new Query();

        if (pageNum != null) {
            int startIndex = (pageNum - 1) * Constants.PAGE_SIZE;

            query.skip(startIndex);
            query.limit(Constants.PAGE_SIZE);
        }

        query.with(new Sort(Sort.Direction.DESC, "id"));

        return mongoTemplate.find(query, UserPO.class);
    }

    public void updateUserLoginIp(String username, String remoteAddress) {

         mongoTemplate.updateFirst(Query.query(Criteria.where("username").is(username)),
                 Update.update("lastLoginIP", remoteAddress).set("lastLoginDate", (new Date()).getTime()), UserPO.class);

    }

}
