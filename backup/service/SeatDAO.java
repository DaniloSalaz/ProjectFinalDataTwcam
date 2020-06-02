package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Seat;

public interface SeatDAO {
	
	public List<Seat> getAircrafs();
	public Seat getSeat(int id);
	public void createSeat(Seat seat);
	public void updateSeat(Seat seat);
	public void deleteSeat(Seat seat);

}
