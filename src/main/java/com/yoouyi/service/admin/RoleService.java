package com.yoouyi.service.admin;

import java.util.List;

import org.bson.types.ObjectId;

import com.yoouyi.model.RolePO;

public interface RoleService {

    public List<RolePO> getRoles(Integer pageNum);

    public int countRolesTotalNum();

    public boolean deleteRole(ObjectId id);

    public boolean addRole(RolePO role);

}
