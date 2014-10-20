package com.zgt.dao.admin;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.zgt.common.Constants;
import com.zgt.model.RolePO;

@Component("roleDAO")
public class RoleDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addRole(RolePO role) {
        sessionFactory.getCurrentSession().save(role);
        return true;
    }

    public RolePO getRoleById(int id) {
        return (RolePO) sessionFactory.getCurrentSession().get(RolePO.class, id);
    }

    public List<RolePO> getRoles(Integer pageNum) {
        String hql = "from RolePO role ORDER BY role.id DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        /**
         * if parameter page is null, we will return all of the roles
         */
        if (pageNum != null) {
            int startIndex = (pageNum-1) * Constants.PAGE_SIZE;
            
            query.setFirstResult(startIndex);
            query.setMaxResults(Constants.PAGE_SIZE);
        }
        
        return query.list();
    }

    /**
     * get the roles total number, for pagination
     * @return
     */
    public int getRolesTotalNum() {
        String hql = "select count(role.id) from RolePO role";
        Long totalNum = (Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return totalNum.intValue() ;
    }

    /**
     * delete a role by role id
     * @param id
     * @return
     */
    public boolean deleteRole(int id) {
        RolePO role = new RolePO();
        role.setId(id);
        sessionFactory.getCurrentSession().delete(role);
        return true;
    }

}
