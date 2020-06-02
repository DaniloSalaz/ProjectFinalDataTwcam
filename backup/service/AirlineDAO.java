package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Airline;

public interface AirlineDAO {

	public List<Airline> getAirline();
	public Airline getAirline(int id);
	public void createAirline(Airline airline);
	public void updateAirline(Airline airline);
	public void deleteAirline(Airline airline);
}
