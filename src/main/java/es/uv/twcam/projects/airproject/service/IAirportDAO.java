package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Airport;

public interface IAirportDAO {

	public List<Airport> getAirports();

	public Airport getAirport(int id);

	public void createAirport(Airport airport);

	public void updateAirport(Airport airport);

	public void deleteAirport(Airport airport);

	public Airport findAirportByIATACode(String iataCode);


}