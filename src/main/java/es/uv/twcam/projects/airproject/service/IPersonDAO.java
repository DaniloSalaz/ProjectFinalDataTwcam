package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.EntityException.PersonNotFoundException;
import es.uv.twcam.projects.airproject.entity.Person;

public interface IPersonDAO {

	public List<Person> getPersons();

	public Person getPerson(int id);

	public void createPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

	public Person findPersonByDNI(String dni) throws PersonNotFoundException;


}