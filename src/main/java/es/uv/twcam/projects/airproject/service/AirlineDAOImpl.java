package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.entity.Airline;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class AirlineDAOImpl extends DataDAOImpl<Integer,Airline> implements IAirlineDAO {

	public AirlineDAOImpl(EntityManager em) {
		super(em, Airline.class);
	}

	@Override
	public List<Airline> getAirlines() {
		return this.findAll();
	}
	@Override
	public Airline getAirline(int id) {
		return this.findById(id);
	}
	@Override
	public void createAirline(Airline airline) {
		this.create(airline);
	}
	@Override
	public void updateAirline(Airline airline) {
		this.update(airline);
	}
	@Override
	public void deleteAirline(Airline airline) {
		this.delete(airline);
	}
	@Override
	public void deteleById(int id) {
		// TODO Auto-generated method stub 

	}
	@Override
	public Airline findAirlineByIATACode(String iataCode) {
		Query query = em.createNamedQuery("Airline.findByIATACode",Airline.class).setParameter(1, iataCode);
		return (Airline) query.getSingleResult();
	}

}