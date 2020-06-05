package es.uv.twcam.projects.airproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Airlines")
@NamedQuery(
		name="Airline.findByIATACode",
		query = "Select a from Airline a where a.iata_code=?1"
		)
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airl_id")
	private int id;

	@Column(name = "airl_IATA_code")
	private String iata_code;

	@Column(name = "airl_name")
	private String name;

	@OneToMany(mappedBy = "airline")
	@JsonIgnore
	private List<Flight> flights;
	
	public Airline() {

	}

	public Airline(String iata_code, String name) {
		super();
		this.iata_code = iata_code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIata_code() {
		return iata_code;
	}

	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return String.format("{id: %s, IATA_CODE: %s, name: %s }", getId(),getIata_code(), getName());
	}
	

}
