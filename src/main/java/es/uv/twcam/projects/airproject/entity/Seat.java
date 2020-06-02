package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seats")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seat_id")
	private int id;
	
	@Column(name="seat_code")
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="fk_airc_id")
	private Aircraft aircraft;
	
	public Seat() {
		
	}

	public Seat(String code) {
		super();
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	
	

}
