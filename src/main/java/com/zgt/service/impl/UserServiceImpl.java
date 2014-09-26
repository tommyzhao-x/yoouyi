package com.zgt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zgt.dao.UserDAO;
import com.zgt.model.UserPO;
import com.zgt.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    @Resource(name = "passwordEncoder")
    private Md5PasswordEncoder passwordEncoder;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Resource
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserPO getUserByName(String userName) {
        return userDAO.getUserByName(userName);
    }

    public boolean addUser(UserPO user) {
        
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        user.setCreatedDate(System.currentTimeMillis());
        user.setModifiedDate(System.currentTimeMillis());
        
        return userDAO.saveUser(user);
    }

    public int countRolesTotalNum() {
        return userDAO.countRolesTotalNum();
    }

    public List<UserPO> getUsers(Integer pageNum) {
        return userDAO.getUsers(pageNum);
    }

    public void updateUserLoginIp(String username, String remoteAddress) {
        userDAO.updateUserLoginIp(username, remoteAddress);
    }

}
