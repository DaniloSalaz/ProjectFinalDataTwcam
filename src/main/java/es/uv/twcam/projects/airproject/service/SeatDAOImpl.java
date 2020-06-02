package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;

import es.uv.twcam.projects.airproject.entity.Seat;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class SeatDAOImpl extends DataDAOImpl<Integer,Seat> implements ISeatDAO {

	public SeatDAOImpl(EntityManager em) {
		super(em, Seat.class);
	}

	@Override
	public List<Seat> getSeats() {
		return this.findAll();
	}
	@Override
	public Seat getSeat(int id) {
		return this.findById(id);
	}
	@Override
	public void createSeat(Seat seat) {
		this.create(seat);
	}
	@Override
	public void updateSeat(Seat seat) {
		this.update(seat);
	}
	@Override
	public void deleteSeat(Seat seat) {
		this.delete(seat);
	}

}