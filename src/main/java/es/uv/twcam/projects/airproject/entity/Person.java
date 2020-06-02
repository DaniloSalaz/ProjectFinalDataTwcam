package es.uv.twcam.projects.airproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pers_id")
	private int id;
	
	@Column(name = "pers_dni")
	private String dni;
	
	@Column(name = "pers_name")
	private String name;
	
	@Column(name = "pers_last_name")
	private String lastName;
	
	@Column(name = "pers_address")
	private String address;
	
	@Column(name = "pers_email")
	private String email;
	
	public Person() {
		
	}

	public Person(String dni, String name, String lastName) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
