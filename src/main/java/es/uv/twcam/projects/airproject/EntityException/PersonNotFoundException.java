package es.uv.twcam.projects.airproject.EntityException;

import javax.persistence.NoResultException;

public class PersonNotFoundException extends NoResultException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3738612911533429330L;
	
	public PersonNotFoundException() {
		this("Person not found!");
	}
	
	public PersonNotFoundException(String message) {
		super(message);
	}

}
