package com.zgt.service;

import java.util.List;

import com.zgt.model.UserPO;

public interface UserService {

    public UserPO getUserByName(String userName);

    public boolean addUser(UserPO user);

    public int countRolesTotalNum();

    public List<UserPO> getUsers(Integer pageNum);

    public void updateUserLoginIp(String username, String remoteAddress);
}
