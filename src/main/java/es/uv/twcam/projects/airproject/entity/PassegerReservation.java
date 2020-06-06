package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Passenger_Reservation")
@IdClass(PassegerReservationId.class)
public class PassegerReservation {

//	@EmbeddedId
//	private PassegerReservationId idPassRese;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_pers_id")
	private Person idPasseger;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_rese_id")
	private Reservation idReservation;
	
	@Column(name = "passenger_priority")
	private boolean priority;
	
	@Column(name = "passeger_ckeck_in")
	private boolean checkIn;
	
	@Column(name = "pass_rese_seat")
	private String seat;

	
	public PassegerReservation() {
		super();
	}

	public PassegerReservation(Person passeger, boolean priority, boolean checkIn) {
		super();
		this.idPasseger = passeger;
		this.priority = priority;
		this.setCheckIn(checkIn);
	}
	

	public PassegerReservation(Person passeger, Reservation reservation, boolean priority, boolean checkIn,
			String seat) {
		super();
		this.idPasseger = passeger;
		this.idReservation = reservation;
		this.priority = priority;
		this.setCheckIn(checkIn);
		this.seat = seat;
	}


	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Reservation getReservation() {
		return idReservation;
	}

	public void setReservation(Reservation reservation) {
		this.idReservation = reservation;
	}

	public Person getPasseger() {
		return idPasseger;
	}

	public void setPasseger(Person passeger) {
		this.idPasseger = passeger;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}
	
	
}
