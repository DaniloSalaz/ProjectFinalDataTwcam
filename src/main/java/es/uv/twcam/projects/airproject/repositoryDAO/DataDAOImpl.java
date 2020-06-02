package es.uv.twcam.projects.airproject.repositoryDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class DataDAOImpl<K,T> implements DataDAO<K,T> {
	
	protected EntityManager em;
	protected Class<T> entityClass;

	protected DataDAOImpl(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}
	
	public T findById(K id) {
		return em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query q = em.createQuery("from " + this.entityClass.getName());
		return q.getResultList();
	}

	public void create(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		
	}

	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		
	}

	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		
	}
	

}
