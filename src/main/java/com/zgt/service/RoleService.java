package com.zgt.service;

import java.util.List;

import com.zgt.model.RolePO;

public interface RoleService {

    public List<RolePO> getRoles(Integer pageNum);

    public int countRolesTotalNum();

    public boolean deleteRole(int id);

    public boolean addRole(RolePO role);

}
