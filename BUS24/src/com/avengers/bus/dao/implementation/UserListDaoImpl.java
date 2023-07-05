package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserListDAO;
import com.avengers.bus.models.entityModels.User;

@Repository
@Transactional
@Component
public class UserListDaoImpl implements UserListDAO {
	@PersistenceContext
	private EntityManager em;

	public void persist(User user) {
		em.persist(user);
	}

	// This will list the all users available
	@Override
	public List<User> UserList(int userId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select u from User u WHERE u.id= :userId", User.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	// This will find the user based on his id
	public User findById(long id) {
		User user = (User) em.find(User.class, id);
		return user;
	}

	// This will update user details
	@Transactional
	public void updateUser(User user) {
		em.merge(user);
	}

}
