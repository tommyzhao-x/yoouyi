package com.zgt.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.zgt.common.Constants;
import com.zgt.model.UserPO;

@Component("userDAO")
public class UserDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserPO getUserByName(String userName) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserPO user where user.username=:userName");

        return (UserPO) query.setString("userName", userName).uniqueResult();
    }

    public boolean saveUser(UserPO user) {
        sessionFactory.getCurrentSession().persist(user);
        return true;
    }

    public int countRolesTotalNum() {
        String hql = "select count(user.id) from UserPO user";
        Long result = (Long) sessionFactory.getCurrentSession()
                .createQuery(hql).uniqueResult();
        return result.intValue();
    }

    public List<UserPO> getUsers(Integer pageNum) {
        String hql = "From UserPO user order by user.id desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        if (pageNum != null) {
            int startIndex = (pageNum - 1) * Constants.PAGE_SIZE;

            query.setFirstResult(startIndex);
            query.setMaxResults(Constants.PAGE_SIZE);
        }

        return query.list();
    }

    public void updateUserLoginIp(String username, String remoteAddress) {
        String hql = "update UserPO user set user.lastLoginIP = :lastLoginIP, user.lastLoginDate = :lastLoginDate WHERE user.username = :username";
        
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("lastLoginIP", remoteAddress);
        query.setLong("lastLoginDate", (new Date()).getTime());
        query.setString("username", username);
        
        query.executeUpdate();
    }

}
