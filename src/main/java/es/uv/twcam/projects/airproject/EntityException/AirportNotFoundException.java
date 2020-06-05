package es.uv.twcam.projects.airproject.EntityException;

import javax.persistence.NoResultException;

public class AirportNotFoundException extends NoResultException{
	
	private static final long serialVersionUID = 1L;

	public AirportNotFoundException() {
		this("Airport not found!");
	}
	
	public AirportNotFoundException(String message) {
		super(message);
	}
	
//	public AirportNotFoundException(String message, Throwable cause) {
//		super(message, cause);
//	}

}
