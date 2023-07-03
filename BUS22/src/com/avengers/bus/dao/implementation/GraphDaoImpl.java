package com.avengers.bus.dao.implementation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.GraphDAO;
import com.avengers.bus.models.dtoModels.MonthlyCollection;
import com.avengers.bus.models.dtoModels.RouteCollection;
import com.avengers.bus.models.dtoModels.TripCollection;

@Component
public class GraphDaoImpl implements GraphDAO {

	@PersistenceContext
	EntityManager em;

	// fetch all the route wise collections
	@Override
	public List<RouteCollection> routeCollection() {
		String hqlQuery = "SELECT r.source, r.destination, r.route_id, SUM(s.collection) " + "FROM Trip t "
				+ "JOIN t.route r " + "JOIN Service s ON t.trip_id = s.trip.trip_id "
				+ "GROUP BY r.source, r.destination, r.route_id " + "ORDER BY r.route_id";

		TypedQuery<Object[]> query = em.createQuery(hqlQuery, Object[].class);
		List<Object[]> results = query.getResultList();
		List<RouteCollection> routeCollections = new ArrayList<>();
		for (Object[] result : results) {
			String source = (String) result[0];
			String destination = (String) result[1];
			int routeId = (int) result[2];
			Long col = (long) result[3];
			double collection = col.doubleValue();

			RouteCollection routeCollection = new RouteCollection(source + " - " + destination, collection);
			routeCollections.add(routeCollection);
			System.out.println(routeCollection);

		}
		return routeCollections;

	}

	// fetch all the trip wise collections
	@Override
	public List<TripCollection> tripCollection() {
		String hqlQuery = "SELECT r.source, r.destination, t.departure, SUM(s.collection) " + "FROM Trip t "
				+ "JOIN t.route r " + "JOIN Service s ON t.trip_id = s.trip.trip_id "
				+ "GROUP BY r.source, r.destination, r.route_id, t.departure, t.trip_id " + "ORDER BY r.route_id";

		TypedQuery<Object[]> query = em.createQuery(hqlQuery, Object[].class);
		List<Object[]> results = query.getResultList();
		List<TripCollection> tcs = new ArrayList<>();
		for (Object[] result : results) {
			String source = (String) result[0];
			String destination = (String) result[1];
			Time time = (Time) result[2];
			Long col = (long) result[3];
			double collection = col.doubleValue();

			TripCollection tc = new TripCollection(source + " - " + destination, time, collection);
			tcs.add(tc);
			System.out.println(tc);

		}
		return tcs;
	}

	// fetch the monthly collections
	@Override
	public List<MonthlyCollection> monthlyCollection() {
		String hqlQuery = "SELECT SUM(s.collection), FUNCTION('TO_CHAR', s.trip_date, 'Month YYYY') AS month_year "
				+ "FROM Service s " + "GROUP BY FUNCTION('TO_CHAR', s.trip_date, 'Month YYYY')";

		TypedQuery<Object[]> query = em.createQuery(hqlQuery, Object[].class);
		List<Object[]> results = query.getResultList();
		List<MonthlyCollection> mcs = new ArrayList<>();
		for (Object[] result : results) {
			String month = (String) result[1];
			Long col = (long) result[0];
			double collection = col.doubleValue();

			MonthlyCollection mc = new MonthlyCollection(month, collection);
			mcs.add(mc);
			System.out.println(mc);

		}
		return mcs;
	}
}
