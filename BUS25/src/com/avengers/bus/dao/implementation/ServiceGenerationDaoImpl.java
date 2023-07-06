package com.avengers.bus.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.ServiceGenerationDAO;

@Component
public class ServiceGenerationDaoImpl implements ServiceGenerationDAO {
	@PersistenceContext
	EntityManager em;

	// It will automatically generate services for the missing days
	@Override
	@Transactional
	public void callAutoGenerateServicesProcedure() {
		Query nativeQuery = em.createNativeQuery("CALL auto_generate_services()");
		nativeQuery.executeUpdate();
	}
}
