package es.uv.twcam.projects.airproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Aircrafts")

@NamedQuery(
		name="Aircraft.findByName",
		query = "Select a from Aircraft a where a.name=?1"
		)
public class Aircraft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airc_id")
	private int id;
	
	@Column(name = "airc_code")
	private String code;
	
	@Column(name = "airc_name")
	private String name;
	
	
	public Aircraft() {
	}

	public Aircraft(String code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
