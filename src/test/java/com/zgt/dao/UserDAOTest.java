package com.zgt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.Test;

import com.zgt.model.RolePO;

public class UserDAOTest {
	
	@Test
	public void saveTeacherTest() {
	    RolePO teacher = new RolePO();
		teacher.setName("gangtao");
		
		EntityManager em = Persistence.createEntityManagerFactory("primary").createEntityManager();
		
        
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(teacher);
		em.flush();
		tx.commit();
	}
	
	@Test
	public void getTeacherTest() {
		EntityManager em = Persistence.createEntityManagerFactory("primary").createEntityManager();
		
		RolePO t = em.find(RolePO.class, 1);
		
		System.out.println(t.getId() +": "+ t.getName());
	}

}
