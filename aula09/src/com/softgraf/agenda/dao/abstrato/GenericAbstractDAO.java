package com.softgraf.agenda.dao.abstrato;

public interface GenericAbstractDAO<T, ID> {
	boolean save(T entity);
	
	T findById(ID peimaryKey);
	
	Iterable<T> findAll();
	
	void delete(T entity);
	
	boolean existsById(ID primatiKey, T emtity);
	
	void update(ID primaryKey, T entity);
	
	long count();

	void delete(Long id);

	boolean existsById(Long id);
	
}