package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Reservation;

public interface ReservationDAO {

	public List<Reservation> getAircrafs();
	public Reservation getReservation(int id);
	public void createReservation(Reservation reservation);
	public void updateReservation(Reservation reservation);
	public void deleteReservation(Reservation reservation);
}
