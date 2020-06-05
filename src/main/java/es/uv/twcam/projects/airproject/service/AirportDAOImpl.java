package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.EntityException.AirportNotFoundException;
import es.uv.twcam.projects.airproject.entity.Airport;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class AirportDAOImpl extends DataDAOImpl<Integer,Airport> implements IAirportDAO {

	public AirportDAOImpl(EntityManager em) {
		super(em, Airport.class);
	}

	@Override
	public List<Airport> getAirports() {
		return this.findAll();
	}
	@Override
	public Airport getAirport(int id) {
		return this.findById(id);
	}
	@Override
	public void createAirport(Airport airport) {
		this.create(airport);
	}
	@Override
	public void updateAirport(Airport airport) {
		this.update(airport);
	}
	@Override
	public void deleteAirport(Airport airport) {
		this.delete(airport);
	}
	@Override
	public Airport findAirportByIATACode(String iataCode) throws AirportNotFoundException{
		Query query = em.createNamedQuery("Airport.findByIATACode", Airport.class).setParameter(1, iataCode); 
		try {
			return (Airport) query.getSingleResult();
		}catch(NoResultException ex) {
			 throw new AirportNotFoundException("Aiport with IATA: '" + iataCode + "'not found!");
		}
	}

}