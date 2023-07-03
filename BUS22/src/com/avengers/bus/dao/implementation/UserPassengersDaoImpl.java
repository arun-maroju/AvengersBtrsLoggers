package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.entityModels.UserPassengersId;

@Repository
@Transactional
@Component
public class UserPassengersDaoImpl implements UserPassengersDAO {
	@PersistenceContext
	EntityManager em;

	// This will persist a passenger for one user
	public void persist(UserPassengers userpass) {
		em.persist(userpass);
	}

	// This will list all the passengers of one particular user
	@Override
	public List<UserPassengers> getAllUserPassengers(int userId) {
		// TODO Auto-generated method stub
		return em.createQuery("Select up From UserPassengers up where up.user_id=" + userId).getResultList();
	}

	// This will update user passengers
	@Transactional
	public void updateUserPassengers(UserPassengersId userpass) {
		em.merge(userpass);

	}

	// This will delete the existing passenger from passenger list for one user
	@Transactional
	public void deleteUserPassengers(UserPassengersId userpass) {
		UserPassengers pass1 = em.find(UserPassengers.class, userpass);
		System.out.print(pass1);
		if (pass1 != null) {
			em.remove(pass1);
		}

	}
}
