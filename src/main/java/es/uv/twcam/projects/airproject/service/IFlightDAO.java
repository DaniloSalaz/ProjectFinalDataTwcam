package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.EntityException.FlightNotFoundException;
import es.uv.twcam.projects.airproject.entity.Flight;

public interface IFlightDAO {

	public List<Flight> getFlights();

	public Flight getFlight(int id);

	public void createFlight(Flight flight);

	public void updateFlight(Flight flight);

	public void deleteFlight(Flight flight);

	public List<Flight> findFligthsByDate(int year, int month, int day, String iataOrigin, String iataDestination, int seats);

	public List<Flight> findFligthsByLTDateLimit(int year, int month, int day, int limit) throws FlightNotFoundException;

	public List<Flight> findFligthsByGTDateLimit(int year, int month, int day, int limit) throws FlightNotFoundException;

	public Flight findFligthByDate(int year, int month, int day) throws FlightNotFoundException;

	public List<Flight> findFlightStatus();


}