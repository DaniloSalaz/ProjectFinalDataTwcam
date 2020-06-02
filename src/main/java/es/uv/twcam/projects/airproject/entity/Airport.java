package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Airports")
@NamedQuery(
		name="Airport.findByIATACode",
		query = "Select a from Airport a where a.iata_code=?1"
		)
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airp_id")
	private int id;

	@Column(name = "airp_IATA_code")
	private String iata_code;

	@Column(name = "airp_name")
	private String name;

	@Column(name = "airp_country")
	private String country;

	@Column(name = "airp_city")
	private String city;
	
	public Airport() {
	}

	public Airport(String iata_code, String name, String country, String city) {
		super();
		this.iata_code = iata_code;
		this.name = name;
		this.country = country;
		this.city = city;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("{id: %s, IATA_CODE: %s, nameAirport: %s, country: %s, city: %s}", 
				getId(), getIata_code(), getName(), getCountry(), getCity());
		
	}
	

}
