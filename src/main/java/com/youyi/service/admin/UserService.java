package com.youyi.service.admin;

import java.util.List;

import com.youyi.model.UserPO;

public interface UserService {

    public UserPO getUserByName(String userName);

    public boolean addUser(UserPO user);

    public int countRolesTotalNum();

    public List<UserPO> getUsers(Integer pageNum);

    public void updateUserLoginIp(String username, String remoteAddress);
}
