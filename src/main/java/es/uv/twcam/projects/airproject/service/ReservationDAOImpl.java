package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;

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

}