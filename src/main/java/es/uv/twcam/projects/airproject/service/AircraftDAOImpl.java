package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.EntityException.AircraftNotFoundException;
import es.uv.twcam.projects.airproject.entity.Aircraft;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class AircraftDAOImpl extends DataDAOImpl<Integer,Aircraft> implements IAircraftDAO {

	public AircraftDAOImpl(EntityManager em) {
		super(em, Aircraft.class);
	}

	@Override
	public List<Aircraft> getAircrafts() {
		return this.findAll();
	}
	@Override
	public Aircraft getAircraft(int id) {
		return this.findById(id);
	}
	@Override
	public void createAircraft(Aircraft aircraft) {
		this.create(aircraft);
	}
	@Override
	public void updateAircraft(Aircraft aircraft) {
		this.update(aircraft);
	}
	@Override
	public void deleteAircraft(Aircraft aircraft) {
		this.delete(aircraft);
	}
	@Override
	public void deteleById(int id) {
		// TODO Auto-generated method stub 

	}
	@Override
	public Aircraft findAircraftByName(String name) throws AircraftNotFoundException{
		Query query = em.createNamedQuery("Aircraft.findByName", Aircraft.class).setParameter(1, name);
		try {
			return (Aircraft) query.getSingleResult();
		} catch (Exception e) {
			String message = "Aircraft wiht name: " + name + " not found";
			throw new AircraftNotFoundException(message);
		}
		
	}

}