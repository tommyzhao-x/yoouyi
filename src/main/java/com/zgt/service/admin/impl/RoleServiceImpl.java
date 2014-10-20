package com.zgt.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zgt.dao.admin.RoleDAO;
import com.zgt.model.RolePO;
import com.zgt.service.admin.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    
    private RoleDAO roleDAO;
    
    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    @Resource
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public List<RolePO> getRoles(Integer pageNum) {
        return roleDAO.getRoles(pageNum);
    }

    public int countRolesTotalNum() {
        return roleDAO.getRolesTotalNum();
    }

    public boolean deleteRole(int id) {
        return roleDAO.deleteRole(id);
    }

    public boolean addRole(RolePO role) {
        return roleDAO.addRole(role);
    }

}
