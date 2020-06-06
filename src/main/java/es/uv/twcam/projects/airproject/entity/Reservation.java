package es.uv.twcam.projects.airproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Reservations")
@NamedQuery(
		name = "Reservation.findResPassengers",
		query = "Select r FROM "
				+ "Reservation r JOIN r.flights f "
				+ "JOIN r.passeger p "
				+ "WHERE f.idFlight.id=?1 "
				+ "ORDER BY p.checkIn"
		)
@NamedQuery(
		name = "Reservation.findFlightSeats",
		query = "Select r FROM "
				+ "Reservation r JOIN r.passeger p "
				+ "JOIN  r.flights f "
				+ "WHERE f.idFlight.id=?1 "
				+ "ORDER BY p.idPasseger.name"
		)
@NamedQuery(
		name = "Reservation.findPassPriority",
		query = "Select r, COUNT(p) FROM "
				+ "Reservation r JOIN r.passeger p "
				+ "WHERE p.priority > 0 "
				+ "GROUP BY p.idPasseger.id ORDER BY p.priority"
		)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rese_id")
	private int id;
	
	@Column(name = "rese_type")
	@Enumerated(EnumType.STRING)
	private ReservationType type;
	
	@Column(name = "rese_baggage_no")
	private int baggageNo;
	
	@Column(name = "rese_priority")
	private int prioriryNo;
	
	@ManyToOne
	@JoinColumn(name = "customer_pers_id")
	private Person person;
	
	
	@OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
	private Payment payment;
	
	@OneToMany(mappedBy = "idReservation", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<FlightReservation> flights;
	
	@OneToMany(mappedBy = "idReservation", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PassegerReservation> passeger;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(
			name="Seats_Reservations",
			joinColumns = @JoinColumn(name="fk_rese_id",referencedColumnName = "rese_id"),
			inverseJoinColumns = @JoinColumn(name="fk_seat_id", referencedColumnName = "seat_id")
			)
	private List<Seat> seatsReservation;

	public enum ReservationType{
		one,round
	}
	
	public Reservation() {
		
	}

	public Reservation(ReservationType type, Person person, Payment payment, List<FlightReservation> flights,
			List<PassegerReservation> passeger, List<Seat> seatsReservation) {
		super();
		this.type = type;
		this.person = person;
		this.payment = payment;
		this.flights = flights;
		this.passeger = passeger;
		this.seatsReservation = seatsReservation;
	}



	public Reservation(ReservationType type, int baggageNo, int prioriryNo, Person person) {
		super();
		this.type = type;
		this.baggageNo = baggageNo;
		this.prioriryNo = prioriryNo;
		this.person = person;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReservationType getType() {
		return type;
	}

	public void setType(ReservationType type) {
		this.type = type;
	}

	public int getBaggageNo() {
		return baggageNo;
	}

	public void setBaggageNo(int baggageNo) {
		this.baggageNo = baggageNo;
	}
	
	public List<FlightReservation> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightReservation> flights) {
		this.flights = flights;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public List<PassegerReservation> getPasseger() {
		return passeger;
	}

	public void setPasseger(List<PassegerReservation> passeger) {
		this.passeger = passeger;
	}

	public int getPrioriryNo() {
		return prioriryNo;
	}

	public void setPrioriryNo(int prioriryNo) {
		this.prioriryNo = prioriryNo;
	}
	
}
