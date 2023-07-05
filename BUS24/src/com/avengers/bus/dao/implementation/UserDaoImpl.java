package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;

@Component
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	EntityManager em;

	// This will find the user based on his email
	@Override
	public User findByEmail(String email) {
		System.out.println("im in findby email method");

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	// This will list all the users availble
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	// This will persist a new user
	@Override
	public void persistUser(User user) {
		System.out.println("Im in user persist method..");
		em.persist(user);
	}

	// This will change the user password
	@Override
	public void changePassword(UserPasswordChange userPasswordChange) {
		System.out.println("the reset email is" + userPasswordChange.getEmail());
		User user = findByEmail(userPasswordChange.getEmail());
		user.setPassword(userPasswordChange.getPassword());
		System.out.println(user);
		em.persist(user);
	}

}
