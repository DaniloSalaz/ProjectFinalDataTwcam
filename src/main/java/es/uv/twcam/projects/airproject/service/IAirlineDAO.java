package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Airline;

public interface IAirlineDAO {

	public List<Airline> getAirlines();

	public Airline getAirline(int id);

	public void createAirline(Airline airline);

	public void updateAirline(Airline airline);

	public void deleteAirline(Airline airline);

	public void deteleById(int id);

	public Airline findAirlineByIATACode(String iataCode);


}