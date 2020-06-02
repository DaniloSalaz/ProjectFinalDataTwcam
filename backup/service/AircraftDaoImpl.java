package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;

import es.uv.twcam.projects.airproject.entity.Aircraft;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class AircraftDaoImpl extends DataDAOImpl<Integer, Aircraft> implements AircraftDAO{

	protected AircraftDaoImpl(EntityManager em) {
		super(em, Aircraft.class);
	}

	public List<Aircraft> getAircrafs() {
		return this.findAll();
	}

	public Aircraft getAircraft(int id) {
		return this.findById(id);
	}

	public void createAircraft(Aircraft aircraft) {
		this.create(aircraft);
		
	}

	public void updateAircraft(Aircraft aircraft) {
		this.update(aircraft);
		
	}

	public void deleteAircraft(Aircraft aircraft) {
		this.delete(aircraft);
		
	}

}
