package es.uv.twcam.projects.airproject.EntityException;

import javax.persistence.NoResultException;

public class FlightNotFoundException extends NoResultException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FlightNotFoundException() {
		this("Flight not found!");
	}
	
	public FlightNotFoundException(String message) {
		super(message);
	}

}
