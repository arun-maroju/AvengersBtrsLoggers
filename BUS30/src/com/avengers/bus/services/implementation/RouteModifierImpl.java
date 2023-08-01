package com.avengers.bus.services.implementation;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.MasterDAO;
import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.entityModels.Route;
import com.avengers.bus.models.entityModels.TripStops;
import com.avengers.bus.models.inputModels.ActivateData;
import com.avengers.bus.models.inputModels.InterStop;
import com.avengers.bus.models.inputModels.Trip;
import com.avengers.bus.services.contracts.RouteModifier;

@Component
public class RouteModifierImpl implements RouteModifier {
	
	@Autowired
	private MasterDAO masterDAO;

	@Override
	public boolean generateRoute(int routeId, String source, String destination) {
		Route route=new Route();
		Route route2=new Route();
		route.setRoute_id(routeId);
		route.setSource(source);
		route.setDestination(destination);
		route.setStatus("new");
		route2.setRoute_id(routeId+1);
		route2.setSource(destination);
		route2.setDestination(source);
		route2.setStatus("new");
		boolean persisted=masterDAO.persistRoute(route,route2);
		if(persisted)
			return true;
		return false;
	}

	@Override
	public boolean deactivateRoute(int routeNumber, String routeSource, String routeDestination) {
		Route route=new Route();
		route.setRoute_id(routeNumber);
		route.setSource(routeSource);
		route.setDestination(routeDestination);
		route.setActive(0);
		route.setStatus("old");
		boolean deactivted=masterDAO.mergeRoute(route);
		if(deactivted)
			return true;
		return false;
	}

	@Override
	public boolean activateRoute(int routeNumber, String routeSource, String routeDestination) {
		Route route=new Route();
		route.setRoute_id(routeNumber);
		route.setSource(routeSource);
		route.setDestination(routeDestination);
		route.setActive(1);
		route.setStatus("old");
		boolean deactivted=masterDAO.mergeRoute(route);
		if(deactivted)
			return true;
		return false;
	}

	@Override
	public boolean activateNewRoute(ActivateData data) {
		List<Trip> trips = data.getTrips();
        List<InterStop> interStops = data.getInterStops();
        
        for(Trip t:trips) {
        	System.out.println(t);
        }
        
        for(InterStop i:interStops) {
        	System.out.println(i);
        }
        
        com.avengers.bus.models.entityModels.Trips tripEntity=new com.avengers.bus.models.entityModels.Trips();
        TripStops ts=new TripStops();
        int lastTrip=masterDAO.getLastTripId();
        int trip_id=lastTrip+1;
        for(Trip t:trips) {
        	tripEntity.setTrip_id(trip_id);
        	tripEntity.setSource(t.getSource());
        	tripEntity.setDestination(t.getDestination());
        	String depTime=t.getDeparture();
        	String arvTime=t.getArrival();
        	
        	 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
             java.util.Date utilDate;
             java.util.Date utilDate2;
             Time sqlTimeDep = null;
             Time sqlTimeArv = null;
			try {
				utilDate = sdf.parse(depTime);
				utilDate2 = sdf.parse(arvTime);
				sqlTimeDep = new Time(utilDate.getTime());
				sqlTimeArv = new Time(utilDate2.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tripEntity.setDeparture(sqlTimeDep);
			tripEntity.setArrival(sqlTimeArv);
			tripEntity.setBus_type(t.getBusType());
			tripEntity.setInter_stops(t.getInterStopsCount());
			tripEntity.setRoute_id(t.getRouteId());
			boolean tripPersisted=masterDAO.persistTrip(tripEntity);
			if(!tripPersisted)
				return false;
             
        	
        	for(InterStop i:interStops) {
        		if(t.getTripNo()==i.getTripNo()) {
        			ts.setTrip_id(trip_id);
        			ts.setStop_id(i.getStop());
        			ts.setStop_index(i.getStopIndex());
        			String stopTime=i.getStopTime();
        			Time sqlStopTime = null;
                    try {
                    	utilDate = sdf.parse(stopTime);
                    	sqlStopTime = new Time(utilDate.getTime());
                    } catch (ParseException e) {
                    	// TODO Auto-generated catch block
                    	e.printStackTrace();
                    }
        			
        			
        			ts.setStop_time(sqlStopTime);
        			boolean tripStopPersisted=masterDAO.persistTripStop(ts);
        			if(!tripStopPersisted)
        				return false;
        		}
        	}
        	
        	trip_id++;
        }
        
        
        
        return true;
	}

	

}
