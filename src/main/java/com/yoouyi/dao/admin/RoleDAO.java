package com.yoouyi.dao.admin;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.yoouyi.common.Constants;
import com.yoouyi.model.RolePO;

@Component("roleDAO")
public class RoleDAO {

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public boolean addRole(RolePO role) {
        mongoTemplate.save(role);
        return true;
    }

    public RolePO getRoleByName(String name) {
        return (RolePO) mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), RolePO.class);
    }

    public List<RolePO> getRoles(Integer pageNum) {
        Query query = new Query();

        if (pageNum != null) {
            int startIndex = (pageNum - 1) * Constants.PAGE_SIZE;

            query.skip(startIndex);
            query.limit(Constants.PAGE_SIZE);
        }

        query.with(new Sort(Sort.Direction.DESC, "id"));

        return mongoTemplate.find(query, RolePO.class);
    }

    /**
     * get the roles total number, for pagination
     * 
     * @return
     */
    public int getRolesTotalNum() {
        Long result = mongoTemplate.count(null, RolePO.class);
        return result.intValue();
    }

    /**
     * delete a role by role id
     * 
     * @param id
     * @return
     */
    public boolean deleteRole(ObjectId id) {
        RolePO role = new RolePO();
        role.setId(id);
        mongoTemplate.remove(role);
        return true;
    }

}
