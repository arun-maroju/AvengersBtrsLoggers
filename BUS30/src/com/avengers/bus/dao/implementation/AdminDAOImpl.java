package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.AdminDAO;
import com.avengers.bus.models.entityModels.Admin;

@Component
public class AdminDAOImpl implements AdminDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public Admin findByUserId(String user_name) {
		System.out.println("im in findby email method");

		TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a WHERE a.user_id = :uname", Admin.class);
		System.out.println("After typed query");
		query.setParameter("uname", user_name);
		System.out.println("After typed query parameter");
		List<Admin> admins = query.getResultList();
		System.out.println("After typed query execution");
		if (!admins.isEmpty()) {
			return admins.get(0);
		}
		return null;
	}
}
