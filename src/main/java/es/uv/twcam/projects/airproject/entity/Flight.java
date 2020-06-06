package es.uv.twcam.projects.airproject.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "Flights")
@NamedQuery(
		name = "Flight.findFlightsDate",
		query = "Select f FROM "
				+ "Flight f JOIN f.origin o JOIN f.destination d "
				+ "WHERE f.year=?1 and f.month=?2 and f.day=?3 "
				+ "and o.iata_code=?4 and d.iata_code=?5 and "
				+ "f.availableSeats >= ?6 and f.reservationDate <= current_date() "
				+ "ORDER BY f.departureTime ASC "
		)
@NamedQuery(
		name = "Flight.findFlightsLTDate",
		query = "Select f FROM "
				+ "Flight f "
				+ "WHERE f.year=?1 and f.month=?2 and f.day >=?3 "
				+ "and f.reservationDate <= current_date() "
				+ "ORDER BY f.availableSeats ASC"
		)
@NamedQuery(
		name = "Flight.findFlightsGTDate",
		query = "Select f FROM "
				+ "Flight f "
				+ "WHERE f.year=?1 and f.month=?2 and f.day >=?3 "
				+ "and f.reservationDate <= current_date() "
				+ "ORDER BY f.availableSeats ASC"
		)
@NamedQuery(
		name = "Flight.findByFlightDate",
		query = "Select f FROM "
				+ "Flight f "
				+ "WHERE f.year=?1 and f.month=?2 and f.day =?3 "
				+ "and f.reservationDate <= current_date() "
				+ "ORDER BY f.availableSeats ASC"
		)
@NamedQuery(
		name = "Flight.findByFlightStatus",
		query = "Select f FROM "
				+ "Flight f JOIN f.reservations r ORDER BY f.status"
		)
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

	@Column(name = "flig_arrival_date")
	private LocalDateTime arrival;
	
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
	@JsonIgnore
	private Airline airline;

	@OneToOne
	@JoinColumn(name = "destination_airp_id", updatable = false)
	private Airport destination;

	@OneToOne
	@JoinColumn(name = "origin_airp_id",updatable = false)
	private Airport origin;

	@ManyToOne
	@JoinColumn(name = "fk_airc_id", updatable = false)
	private Aircraft aircraft;
	
	@OneToMany(mappedBy = "flight")
	@JsonIgnore
	private List<Seat> seats;
	
	@OneToMany(mappedBy = "idFlight")
	@JsonIgnore
	private List<FlightReservation> reservations;
	
	@Column(name = "flig_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status {
		scheduled, landed
	}

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
			String boardingTime, LocalDateTime arrival, int airTime, int availableSeats, float cost, float priorityCost, float baggageCost,
			Airline airline, Airport destination, Airport origin, Aircraft aircraft, Status status) {
		super();
		this.reservationDate = reservationDate;
		this.year = year;
		this.month = month;
		this.day = day;
		this.departureTime = departureTime;
		this.boardingTime = boardingTime;
		this.arrival = arrival;
		this.airTime = airTime;
		this.availableSeats = availableSeats;
		this.cost = cost;
		this.priorityCost = priorityCost;
		this.baggageCost = baggageCost;
		this.airline = airline;
		this.destination = destination;
		this.origin = origin;
		this.aircraft = aircraft;
		this.status = status;
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
				+ "costoPrioridad: %s, costoEquipajeExtra: %s, Aerolinea: %s, Destino: %s, Origen: %s, Avion: %s, Status: %s}", 
				getId(),getReservationDate() ,getYear(), getMonth(), getDay(), getDepartureTime(), getBoardingTime(),getAirTime(), getCost(), getPriorityCost(), 
				getBaggageCost(), getAirline().getName(), getDestination().getName(), getOrigin().getName(),
				getAircraft().getName(), getStatus());
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<FlightReservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<FlightReservation> reservations) {
		this.reservations = reservations;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
	

}
