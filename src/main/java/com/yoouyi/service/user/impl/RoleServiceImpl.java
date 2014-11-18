package com.yoouyi.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoouyi.dao.admin.RoleDAO;
import com.yoouyi.model.user.RolePO;
import com.yoouyi.service.user.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleDAO roleDAO;

    public List<RolePO> getRoles(Integer pageNum) {
        return roleDAO.getRoles(pageNum);
    }

    public int countRolesTotalNum() {
        return roleDAO.getRolesTotalNum();
    }

    public boolean deleteRole(ObjectId id) {
        return roleDAO.deleteRole(id);
    }

    public boolean addRole(RolePO role) {
        return roleDAO.addRole(role);
    }

    public RolePO getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

}
