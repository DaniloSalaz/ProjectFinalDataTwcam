package es.uv.twcam.projects.airproject.entity;

import java.io.Serializable;


public class FlightReservationId implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idFlight;
	
	private int idReservation;
	

	public FlightReservationId() {
	}

	public FlightReservationId(int idFlight, int idReservation) {
		super();
		this.idFlight = idFlight;
		this.idReservation = idReservation;
	}
	
	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public int getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFlight;
		result = prime * result + idReservation;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightReservationId other = (FlightReservationId) obj;
		if (idFlight != other.idFlight)
			return false;
		if (idReservation != other.idReservation)
			return false;
		return true;
	}
	
}
