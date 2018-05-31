package pe.edu.upc.service;

import java.util.List;

public interface IService <T,ID>{
	public List<T> findAll();
	public T findById(ID id);
	public void save(T entity);
	public void deleteById(ID id);
	public void delete(T entity);
}
