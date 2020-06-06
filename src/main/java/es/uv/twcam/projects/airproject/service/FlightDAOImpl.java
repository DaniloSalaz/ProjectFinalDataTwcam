package es.uv.twcam.projects.airproject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.EntityException.FlightNotFoundException;
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
	public List<Flight> findFligthsByDate(int year, int month, int day, String iataOrigin, String iataDestination, int seats) throws FlightNotFoundException{
		Query query = em.createNamedQuery("Flight.findFlightsDate",Flight.class)
				.setParameter(1, year)
				.setParameter(2, month)
				.setParameter(3, day)
				.setParameter(4, iataOrigin)
				.setParameter(5, iataDestination)
				.setParameter(6, seats);
		
		try {
			return (List<Flight>) query.getResultList();
		}catch(NoResultException ex){
			String message = "Flight with date:" + year + "-" + month + "-" + day + ", destination :" + iataDestination 
					+ " origin: " + iataOrigin + ", seats: " + seats + " not found";
			throw new FlightNotFoundException(message);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findFligthsByLTDateLimit(int year, int month, int day, int limit) throws FlightNotFoundException{
		Query query = em.createNamedQuery("Flight.findFlightsLTDate",Flight.class)
				.setParameter(1, year)
				.setParameter(2, month)
				.setParameter(3, day);
		
		try {
			return (List<Flight>) query.getResultList().stream().limit(limit).collect(Collectors.toList());
		}catch(NoResultException ex){
			String message = "Flight with date:" + year + "-" + month + "-" + day + " not found";
			throw new FlightNotFoundException(message);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findFligthsByGTDateLimit(int year, int month, int day, int limit) throws FlightNotFoundException{
		Query query = em.createNamedQuery("Flight.findFlightsGTDate",Flight.class)
				.setParameter(1, year)
				.setParameter(2, month)
				.setParameter(3, day);
		try {
			return (List<Flight>) query.getResultList().stream().limit(limit).collect(Collectors.toList());
		}catch(NoResultException ex){
			String message = "Flight with date:" + year + "-" + month + "-" + day + " not found";
			throw new FlightNotFoundException(message);
		}
	}
	
	@Override
	public Flight findFligthByDate(int year, int month, int day) throws FlightNotFoundException{
		Query query = em.createNamedQuery("Flight.findByFlightDate",Flight.class)
				.setParameter(1, year)
				.setParameter(2, month)
				.setParameter(3, day);
		
		try {
			return (Flight) query.getResultList().get(0);
		}catch(NoResultException ex){
			String message = "Flight with date:" + year + "-" + month + "-" + day + " not found";
			throw new FlightNotFoundException(message);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findFlightStatus() {
		Query query = em.createNamedQuery("Flight.findByFlightStatus",Flight.class);
		try {
			return (List<Flight>) query.getResultList();
		}catch(NoResultException ex){
			throw new FlightNotFoundException();
		}
	}
	

}