package com.avengers.bus.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.MasterDAO;
import com.avengers.bus.models.entityModels.Route;
import com.avengers.bus.models.entityModels.TripStops;
import com.avengers.bus.models.entityModels.Trips;

@Repository
@Transactional
@Component
public class MasterDAOImpl implements MasterDAO {
	
	@PersistenceContext
	EntityManager em;
	
	private JdbcTemplate jdbcTemplate;
	
	public MasterDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	@Override
	public boolean persistRoute(Route route,Route route2) {
		try {
		em.persist(route);
		em.persist(route2);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Transactional
	@Override
	public boolean mergeRoute(Route route) {
		try {
			em.merge(route);
			}
			catch(Exception e) {
				System.out.println(e);
				return false;
			}
			return true;
	}

	@Transactional
	@Override
	public int getLastTripId() {
	    Integer lastTripId = em.createQuery("SELECT MAX(t.trip_id) FROM Trip t", Integer.class).getSingleResult();
	    return lastTripId != null ? lastTripId : 0;
	}


	@Transactional
	@Override
	public boolean persistTrip(Trips tripEntity) {
		
		String query="insert into btrs_trips values(?,?,?,?,?,?,?,?)";
		
		try {
	        int rowsAffected = jdbcTemplate.update(query,
	                tripEntity.getTrip_id(),
	                tripEntity.getSource(),
	                tripEntity.getDestination(),
	                tripEntity.getDeparture(),
	                tripEntity.getArrival(),
	                tripEntity.getBus_type(),
	                tripEntity.getInter_stops(),
	                tripEntity.getRoute_id());

	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
		
}

	@Transactional
	@Override
	public boolean persistTripStop(TripStops ts) {
		try {
			System.out.println("About to persist Trip Stop");
			System.out.println(ts);
			em.persist(ts);
			System.out.println(ts);
			System.out.println("Trip Stop Persisted");
			return true;
			}
			catch(Exception e)
			{
			return false;
			}
	}

}
