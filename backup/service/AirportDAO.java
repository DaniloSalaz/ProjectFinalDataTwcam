package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Airport;

public interface AirportDAO {

	public List<Airport> getAircrafs();
	public Airport getAirport(int id);
	public void createAirport(Airport airport);
	public void updateAirport(Airport airport);
	public void deleteAirport(Airport airport);
}
