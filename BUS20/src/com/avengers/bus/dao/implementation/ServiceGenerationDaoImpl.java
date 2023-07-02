package com.avengers.bus.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.ServiceGenerationDAO;

@Component
public class ServiceGenerationDaoImpl implements ServiceGenerationDAO {
	private static final Logger logger = LoggerFactory.getLogger(ServiceGenerationDaoImpl.class);

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void callAutoGenerateServicesProcedure() {
		 logger.info("Calling auto_generate_services procedure");

	        try {
	            Query nativeQuery = em.createNativeQuery("CALL auto_generate_services()");
	            nativeQuery.executeUpdate();
	            logger.info("auto_generate_services procedure executed successfully");
	        } catch (Exception e) {
	            logger.error("Error calling auto_generate_services procedure: {}", e.getMessage());
	            // Handle or rethrow the exception as needed
	        }
	}
}
