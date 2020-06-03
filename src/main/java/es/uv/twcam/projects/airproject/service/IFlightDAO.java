package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Flight;

public interface IFlightDAO {

	public List<Flight> getFlights();

	public Flight getFlight(int id);

	public void createFlight(Flight flight);

	public void updateFlight(Flight flight);

	public void deleteFlight(Flight flight);

	List<Flight> findFligthsByDate(int year, int month, int day, String iataOrigin, String iataDestination, int seats);


}