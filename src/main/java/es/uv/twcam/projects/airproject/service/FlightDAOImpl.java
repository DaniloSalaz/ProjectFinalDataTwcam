package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.entity.Flight;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class FlightDAOImpl extends DataDAOImpl<Integer,Flight> implements IFlightDAO {

	public FlightDAOImpl(EntityManager em) {
		super(em, Flight.class);
	}

	@Override
	public List<Flight> getFlights() {
		return this.findAll();
	}
	@Override
	public Flight getFlight(int id) {
		return this.findById(id);
	}
	@Override
	public void createFlight(Flight flight) {
		this.create(flight);
	}
	@Override
	public void updateFlight(Flight flight) {
		this.update(flight);
	}
	@Override
	public void deleteFlight(Flight flight) {
		this.delete(flight);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Flight> findFligthsByDate(int year, int month, int day, String iataOrigin, String iataDestination, int seats) {
		Query query = em.createNamedQuery("Flight.findFlightsDate",Flight.class)
				.setParameter(1, year)
				.setParameter(2, month)
				.setParameter(3, day)
				.setParameter(4, iataOrigin)
				.setParameter(5, iataDestination)
				.setParameter(6, seats);
		return (List<Flight>) query.getResultList();
	}
	

}