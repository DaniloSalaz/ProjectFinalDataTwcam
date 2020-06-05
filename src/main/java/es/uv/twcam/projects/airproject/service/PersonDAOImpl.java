package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.uv.twcam.projects.airproject.EntityException.PersonNotFoundException;
import es.uv.twcam.projects.airproject.entity.Person;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class PersonDAOImpl extends DataDAOImpl<Integer,Person> implements IPersonDAO {

	public PersonDAOImpl(EntityManager em) {
		super(em, Person.class);
	}

	@Override
	public List<Person> getPersons() {
		return this.findAll();
	}
	@Override
	public Person getPerson(int id) {
		return this.findById(id);
	}
	@Override
	public void createPerson(Person person) {
		this.create(person);
	}
	@Override
	public void updatePerson(Person person) {
		this.update(person);
	}
	@Override
	public void deletePerson(Person person) {
		this.delete(person);
	}

	@Override
	public Person findPersonByDNI(String dni) throws PersonNotFoundException {
		Query query = em.createNamedQuery("Person.findByDNI",Person.class);
		try {
			return (Person) query.getSingleResult();
		} catch (NoResultException e) {
			throw new PersonNotFoundException();
		}
	}
}