package es.uv.twcam.projects.airproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flights_Reservations")
@IdClass(FlightReservationId.class)
public class FlightReservation {
//
//	@EmbeddedId
//	private FlightReservationId idFligRese;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_flig_id")
	private Flight idFlight;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_rese_id")
	private Reservation idReservation;

	@Column(name = "flig_rese_date")
	private LocalDate date;
	
	

	public FlightReservation() {

	}

	
	public FlightReservation(Flight flight, Reservation reservation, LocalDate date) {
		super();
		this.idFlight = flight;
		this.idReservation = reservation;
		this.date = date;
	}

	public FlightReservation(Flight flight) {
		super();
		this.idFlight = flight;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Flight getFlight() {
		return idFlight;
	}

	public void setFlight(Flight flight) {
		this.idFlight = flight;
	}

	public Reservation getReservation() {
		return idReservation;
	}

	public void setReservation(Reservation reservation) {
		this.idReservation = reservation;
	}

}
