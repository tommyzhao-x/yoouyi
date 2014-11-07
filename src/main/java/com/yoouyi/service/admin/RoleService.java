package com.yoouyi.service.admin;

import java.util.List;

import com.yoouyi.model.RolePO;

public interface RoleService {

    public List<RolePO> getRoles(Integer pageNum);

    public int countRolesTotalNum();

    public boolean deleteRole(int id);

    public boolean addRole(RolePO role);

}
