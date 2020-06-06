package es.uv.twcam.projects.airproject.repositoryDAO;

import es.uv.twcam.projects.airproject.service.IPersonDAO;
import es.uv.twcam.projects.airproject.service.IAircraftDAO;
import es.uv.twcam.projects.airproject.service.IReservationDAO;
import es.uv.twcam.projects.airproject.service.IFlightDAO;
import es.uv.twcam.projects.airproject.service.ISeatDAO;
import es.uv.twcam.projects.airproject.service.IPaymentDAO;
import es.uv.twcam.projects.airproject.service.IAirportDAO;
import es.uv.twcam.projects.airproject.service.IAirlineDAO;

public abstract class DataDAOFactory {

	public enum TYPE{JPA,XML}

	public abstract IPersonDAO getPersonDAO();

	public abstract IAircraftDAO getAircraftDAO();

	public abstract IReservationDAO getReservationDAO();

	public abstract IFlightDAO getFlightDAO();

	public abstract ISeatDAO getSeatDAO();

	public abstract IPaymentDAO getPaymentDAO();

	public abstract IAirportDAO getAirportDAO();

	public abstract IAirlineDAO getAirlineDAO();

	public static DataDAOFactory getDAOFactory(TYPE t) {
		switch(t) {
			case JPA:
				return new JPADAOFactory();
			default:
				break;
		}
		return null;
	}
}
