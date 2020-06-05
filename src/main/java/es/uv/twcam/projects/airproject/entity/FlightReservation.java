package es.uv.twcam.projects.airproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Flights_Reservations")
public class FlightReservation {

	@EmbeddedId
	private FlightReservationId idFligRese;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idFlight")
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idReservation")
	private Reservation reservation;

	@Column(name = "flig_rese_date")
	private LocalDate date;
	
	@Column(name = "flig_state")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status {
		scheduled, landed
	}

	public FlightReservation() {

	}

	public FlightReservation(FlightReservationId id, LocalDate date, Status status) {
		super();
		this.idFligRese = id;
		this.date = date;
		this.status =status;  
	}

	
	public FlightReservation(Flight flight, Status status) {
		super();
		this.flight = flight;
		this.status = status;
	}

	public FlightReservationId getId() {
		return idFligRese;
	}

	public void setId(FlightReservationId id) {
		this.idFligRese = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Status getState() {
		return status;
	}

	public void setState(Status status) {
		this.status = status;
	}

}
