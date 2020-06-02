package es.uv.twcam.projects.airproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservations")
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
	
	@OneToOne
	@JoinColumn(name = "fk_paym_id")
	private Payment payment;
	
	@OneToMany(mappedBy = "reservation")
	private List<FlightReservation> fligths;
	
	@OneToMany(mappedBy = "reservation")
	private List<PassegerReservation> passeger;
	
	@ManyToMany
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
	
	public Reservation(ReservationType type, List<FlightReservation> fligths) {
		super();
		this.type = type;
		this.fligths = fligths;
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
	
	public List<FlightReservation> getFligths() {
		return fligths;
	}

	public void setFligths(List<FlightReservation> fligths) {
		this.fligths = fligths;
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
