package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Passeger_Reservation")
public class PassegerReservation {

	@EmbeddedId
	private PassegerReservationId idPassRese;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idPasseger")
	private Person passeger;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idReservation")
	private Reservation reservation;
	
	@Column(name = "passenger_priority")
	private boolean priority;
	
	@Column(name = "passeger_ckeck_in")
	private boolean checkIn;
	
	@Column(name = "pass_rese_seat")
	private String seat;

	
	public PassegerReservation() {
		super();
	}

	public PassegerReservation(PassegerReservationId idPassRese, boolean priority) {
		super();
		this.idPassRese = idPassRese;
		this.priority = priority;
	}
	

	public PassegerReservation(Person passeger, boolean priority, boolean checkIn) {
		super();
		this.passeger = passeger;
		this.priority = priority;
		this.checkIn = checkIn;
	}

	public PassegerReservationId getIdPassRese() {
		return idPassRese;
	}

	public void setIdPassRese(PassegerReservationId idPassRese) {
		this.idPassRese = idPassRese;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Person getPasseger() {
		return passeger;
	}

	public void setPasseger(Person passeger) {
		this.passeger = passeger;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
