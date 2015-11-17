package com.earl.fishshop.base;

import java.util.List;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public interface BaseDao<T> {

	Session getCurrentSession();

	void save(T t);

	void update(T t);

	void deleteById(Long id);

	/**
	 * findById 功能跟get(int )一样
	 * 
	 * @param id
	 * @return
	 */
	T get(Long id);

	List<T> findAll();

	void deleteAll();

	void delete(T persistentInstance);

//	List<T> pageFindAll(PageInfo pageInfo);
	
	public List<T> findByGivenCriteria(T object);

	void updateWithNotNullProperties(T object);

//	public List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
	
}