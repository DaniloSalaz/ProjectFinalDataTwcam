package es.uv.twcam.projects.airproject.entity;

import java.io.Serializable;




public class PassegerReservationId implements Serializable{

	private static final long serialVersionUID = 6852825333058733446L;
	
	private int idPasseger;
	
	private int idReservation;


	public PassegerReservationId() {
		super();
	}

	public PassegerReservationId(int idPasseger, int idReservation) {
		super();
		this.idPasseger = idPasseger;
		this.idReservation = idReservation;
	}

	public int getIdPasseger() {
		return idPasseger;
	}

	public void setIdPasseger(int idPassager) {
		this.idPasseger = idPassager;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPasseger;
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
		PassegerReservationId other = (PassegerReservationId) obj;
		if (idPasseger != other.idPasseger)
			return false;
		if (idReservation != other.idReservation)
			return false;
		return true;
	}
	
	
}
