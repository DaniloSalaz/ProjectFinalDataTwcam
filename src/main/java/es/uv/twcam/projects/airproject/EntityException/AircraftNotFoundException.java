package es.uv.twcam.projects.airproject.EntityException;

import javax.persistence.NoResultException;

public class AircraftNotFoundException extends NoResultException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 913112511687016553L;

	public AircraftNotFoundException() {
		this("Aircraft not found");
	}
	
	public AircraftNotFoundException(String message) {
		super(message);
	}
}
