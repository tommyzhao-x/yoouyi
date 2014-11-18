package com.yoouyi.service.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.yoouyi.model.user.RolePO;

public interface RoleService {

    public List<RolePO> getRoles(Integer pageNum);
    
    public RolePO getRoleByName(String name);

    public int countRolesTotalNum();

    public boolean deleteRole(ObjectId id);

    public boolean addRole(RolePO role);

}
