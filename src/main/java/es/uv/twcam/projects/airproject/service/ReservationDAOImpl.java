package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.EntityException.FlightNotFoundException;
import es.uv.twcam.projects.airproject.EntityException.PersonNotFoundException;
import es.uv.twcam.projects.airproject.entity.Reservation;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class ReservationDAOImpl extends DataDAOImpl<Integer,Reservation> implements IReservationDAO {

	public ReservationDAOImpl(EntityManager em) {
		super(em, Reservation.class);
	}

	@Override
	public List<Reservation> getReservations() {
		return this.findAll();
	}
	@Override
	public Reservation getReservation(int id) {
		return this.findById(id);
	}
	@Override
	public void createReservation(Reservation reservation) {
		this.create(reservation);
	}
	@Override
	public void updateReservation(Reservation reservation) {
		this.update(reservation);
	}
	@Override
	public void deleteReservation(Reservation reservation) {
		this.delete(reservation);
	}
	
	@Override
	public Reservation findByFlight(int idFlight) {
		
		Query query = em.createNamedQuery("Reservation.findResPassengers",Reservation.class).setParameter(1, idFlight);
		try {
			return (Reservation) query.getResultList().get(0);
		}catch(NoResultException ex){
			throw new FlightNotFoundException();
		}
	}
	
	@Override
	public Reservation findSeatsByFlight(int idFlight) {
		
		Query query = em.createNamedQuery("Reservation.findFlightSeats",Reservation.class).setParameter(1, idFlight);
		try {
			return (Reservation) query.getResultList().get(0);
		}catch(NoResultException ex){
			throw new FlightNotFoundException();
		}
	}
	
	@Override
	public Reservation findPassengerPriority() {
		
		Query query = em.createNamedQuery("Reservation.findPassPriority",Reservation.class);
		try {
			return (Reservation) query.getResultList().get(0);
		}catch(NoResultException ex){
			throw new PersonNotFoundException();
		}
	}
	
	
	

}