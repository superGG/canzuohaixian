package com.earl.fishshop.service;

import java.util.List;

public interface BaseService<T> {

	Boolean save(T model);

	Boolean update(T t);

	Boolean deleteById(Integer id);

	List<T> findAll();

//	List<T> pagefindAll(PageInfo pageInfo);

	T get(Integer id);
	
	List<T> findByGivenCreteria(T object);
	
//	List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
}
