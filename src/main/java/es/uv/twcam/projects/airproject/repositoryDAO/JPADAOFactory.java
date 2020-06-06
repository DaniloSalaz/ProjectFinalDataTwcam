package es.uv.twcam.projects.airproject.repositoryDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uv.twcam.projects.airproject.service.PersonDAOImpl;
import es.uv.twcam.projects.airproject.service.IPersonDAO;
import es.uv.twcam.projects.airproject.service.AircraftDAOImpl;
import es.uv.twcam.projects.airproject.service.IAircraftDAO;
import es.uv.twcam.projects.airproject.service.ReservationDAOImpl;
import es.uv.twcam.projects.airproject.service.IReservationDAO;
import es.uv.twcam.projects.airproject.service.FlightDAOImpl;
import es.uv.twcam.projects.airproject.service.IFlightDAO;
import es.uv.twcam.projects.airproject.service.SeatDAOImpl;
import es.uv.twcam.projects.airproject.service.ISeatDAO;
import es.uv.twcam.projects.airproject.service.PaymentDAOImpl;
import es.uv.twcam.projects.airproject.service.IPaymentDAO;
import es.uv.twcam.projects.airproject.service.AirportDAOImpl;
import es.uv.twcam.projects.airproject.service.IAirportDAO;
import es.uv.twcam.projects.airproject.service.AirlineDAOImpl;
import es.uv.twcam.projects.airproject.service.IAirlineDAO;

 public class JPADAOFactory extends DataDAOFactory {

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acmeAeropuerto");
		return emf.createEntityManager();
		}

	@Override
	public IPersonDAO getPersonDAO() {
		return new PersonDAOImpl(getEntityManager());
	}

	@Override
	public IAircraftDAO getAircraftDAO() {
		return new AircraftDAOImpl(getEntityManager());
	}

	@Override
	public IReservationDAO getReservationDAO() {
		return new ReservationDAOImpl(getEntityManager());
	}

	@Override
	public IFlightDAO getFlightDAO() {
		return new FlightDAOImpl(getEntityManager());
	}

	@Override
	public ISeatDAO getSeatDAO() {
		return new SeatDAOImpl(getEntityManager());
	}

	@Override
	public IPaymentDAO getPaymentDAO() {
		return new PaymentDAOImpl(getEntityManager());
	}

	@Override
	public IAirportDAO getAirportDAO() {
		return new AirportDAOImpl(getEntityManager());
	}

	@Override
	public IAirlineDAO getAirlineDAO() {
		return new AirlineDAOImpl(getEntityManager());
	}

}
