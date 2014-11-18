package com.yoouyi.service.user;

import java.util.List;

import com.yoouyi.model.user.UserPO;

public interface UserService {

    public UserPO getUserByName(String userName);

    public boolean addUser(UserPO user);

    public int countUsersTotalNum();

    public List<UserPO> getUsers(Integer pageNum);

    public void updateUserLoginIp(String username, String remoteAddress);
}
