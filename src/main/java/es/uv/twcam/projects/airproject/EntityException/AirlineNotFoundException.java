package es.uv.twcam.projects.airproject.EntityException;

import javax.persistence.NoResultException;

public class AirlineNotFoundException extends NoResultException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AirlineNotFoundException() {
		this("Airline not found");
	}
	
	public AirlineNotFoundException(String message) {
		super(message);
	}

}
