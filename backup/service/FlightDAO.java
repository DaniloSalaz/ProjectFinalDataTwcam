package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Flight;

public interface FlightDAO {

	public List<Flight> getAircrafs();
	public Flight getFlight(int id);
	public void createFlight(Flight flight);
	public void updateFlight(Flight flight);
	public void deleteFlight(Flight flight);
}
