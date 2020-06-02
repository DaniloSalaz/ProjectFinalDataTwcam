package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;

import es.uv.twcam.projects.airproject.entity.Flight;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class FlightDAOImpl extends DataDAOImpl<Integer,Flight> implements IFlightDAO {

	public FlightDAOImpl(EntityManager em) {
		super(em, Flight.class);
	}

	@Override
	public List<Flight> getFlights() {
		return this.findAll();
	}
	@Override
	public Flight getFlight(int id) {
		return this.findById(id);
	}
	@Override
	public void createFlight(Flight flight) {
		this.create(flight);
	}
	@Override
	public void updateFlight(Flight flight) {
		this.update(flight);
	}
	@Override
	public void deleteFlight(Flight flight) {
		this.delete(flight);
	}

}