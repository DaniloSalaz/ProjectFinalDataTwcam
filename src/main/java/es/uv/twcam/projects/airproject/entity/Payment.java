package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paym_id")
	private int id;

	@Column(name = "paym_subtotal_baggage")
	private float subtotalBaggage;

	@Column(name = "paym_subtotal_priority")
	private float subtotalPrioriry;

	@Column(name = "paym_subtotal_flight")
	private float subtotalFlight;

	@Column(name = "paym_total")
	private float total;
	
	@OneToOne
	@JoinColumn(name = "fk_rese_id")
	private Reservation reservation;

	public Payment() {

	}

	public Payment(float subtotalBaggage, float subtotalPrioriry, float subtotalFlight, float total) {
		super();
		this.subtotalBaggage = subtotalBaggage;
		this.subtotalPrioriry = subtotalPrioriry;
		this.subtotalFlight = subtotalFlight;
		this.total = total;
	}

	public Payment(float subtotalBaggage, float subtotalPrioriry, float subtotalFlight, float total,
			Reservation reservation) {
		super();
		this.subtotalBaggage = subtotalBaggage;
		this.subtotalPrioriry = subtotalPrioriry;
		this.subtotalFlight = subtotalFlight;
		this.total = total;
		this.reservation = reservation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSubtotalBaggage() {
		return subtotalBaggage;
	}

	public void setSubtotalBaggage(float subtotalBaggage) {
		this.subtotalBaggage = subtotalBaggage;
	}

	public float getSubtotalPrioriry() {
		return subtotalPrioriry;
	}

	public void setSubtotalPrioriry(float subtotalPrioriry) {
		this.subtotalPrioriry = subtotalPrioriry;
	}

	public float getSubtotalFlight() {
		return subtotalFlight;
	}

	public void setSubtotalFlight(float subtotalFlight) {
		this.subtotalFlight = subtotalFlight;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
