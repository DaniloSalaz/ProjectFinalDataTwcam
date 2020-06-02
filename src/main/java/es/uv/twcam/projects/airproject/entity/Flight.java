package es.uv.twcam.projects.airproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flig_id")
	private int id;

	@Column(name = "flig_reservation_date")
	private LocalDate reservationDate;

	@Column(name = "flig_year")
	private int year;

	@Column(name = "flig_month")
	private int month;

	@Column(name = "flig_day")
	private int day;

	@Column(name = "flig_departure_time")
//	@Column(name = "flig_departurte_time")
	private String departureTime;

	@Column(name = "flig_boarding_time")
	private String boardingTime;

	@Column(name = "flig_air_time")
	private int airTime;

	@Column(name = "flig_available_seats")
	private int availableSeats;

	@Column(name = "flig_cost")
	private float cost;

	@Column(name = "flig_priority_cost")
	private float priorityCost;

	@Column(name = "flig_baggage_cost")
	private float baggageCost;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_airl_id", updatable = false)
	private Airline airline;

	@OneToOne
	@JoinColumn(name = "destination_airp_id", updatable = false)
//	@JoinColumn(name = "desrination_airp_id",updatable = false)
	private Airport destination;

	@OneToOne
	@JoinColumn(name = "origin_airp_id",updatable = false)
	private Airport origin;

	@ManyToOne
	@JoinColumn(name = "fk_airc_id", updatable = false)
	private Aircraft aircraft;
	

	public Flight() {

	}

	public Flight(LocalDate reservationDate, int year, int month, int day, String departureTime, String boardingTime,
			float cost, Airport destination, Airport origin) {
		super();
		this.reservationDate = reservationDate;
		this.year = year;
		this.month = month;
		this.day = day;
		this.departureTime = departureTime;
		this.boardingTime = boardingTime;
		this.cost = cost;
		this.destination = destination;
		this.origin = origin;
	}
	

	public Flight(LocalDate reservationDate, int year, int month, int day, String departureTime,
			String boardingTime, int airTime, int availableSeats, float cost, float priorityCost, float baggageCost,
			Airline airline, Airport destination, Airport origin, Aircraft aircraft) {
		super();
		this.reservationDate = reservationDate;
		this.year = year;
		this.month = month;
		this.day = day;
		this.departureTime = departureTime;
		this.boardingTime = boardingTime;
		this.airTime = airTime;
		this.availableSeats = availableSeats;
		this.cost = cost;
		this.priorityCost = priorityCost;
		this.baggageCost = baggageCost;
		this.airline = airline;
		this.destination = destination;
		this.origin = origin;
		this.aircraft = aircraft;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public int getAirTime() {
		return airTime;
	}

	public void setAirTime(int airTime) {
		this.airTime = airTime;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getPriorityCost() {
		return priorityCost;
	}

	public void setPriorityCost(float priorityCost) {
		this.priorityCost = priorityCost;
	}

	public float getBaggageCost() {
		return baggageCost;
	}

	public void setBaggageCost(float baggageCost) {
		this.baggageCost = baggageCost;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return String.format("{id: %s, FechaReservacion: %s, Año: %s, Mes: %s, Día: %s, HoraSalida: %s, HoraEmbarque: %s, TiempoVuelo: %s, Costo: %s, "
				+ "costoPrioridad: %s, costoEquipajeExtra: %s, Aerolinea: %s, Destino: %s, Origen: %s, Avion: %s}", 
				getId(),getReservationDate() ,getYear(), getMonth(), getDay(), getDepartureTime(), getBoardingTime(),getAirTime(), getCost(), getPriorityCost(), 
				getBaggageCost(), getAirline().getName(), getDestination().getName(), getOrigin().getName(),
				getAircraft().getName());
	}
	

}
