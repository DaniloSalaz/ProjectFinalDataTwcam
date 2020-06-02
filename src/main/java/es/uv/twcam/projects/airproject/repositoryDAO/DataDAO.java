package es.uv.twcam.projects.airproject.repositoryDAO;

import java.util.List;

public interface DataDAO<K,T>{
	
	public T findById(K id);
	public List<T> findAll();
	public void create(T entity);
	public void update(T entity);
	public void delete(T enetity);

}
