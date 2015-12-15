package com.earl.fishshop.domain.base;

import java.util.List;

import org.hibernate.Session;

import com.earl.fishshop.vo.PageInfo;


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

	List<T> findAll(PageInfo pageInfo);
	
	void deleteAll();

	void delete(T persistentInstance);

//	List<T> pageFindAll(PageInfo pageInfo);
	
	public List<T> findByGivenCriteria(T object);

	void updateWithNotNullProperties(T object);

	List<T> findLikeGivenCreteriaWithPage(T object, PageInfo pageInfo);

//	public List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
	
}