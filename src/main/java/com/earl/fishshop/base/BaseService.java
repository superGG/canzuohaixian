package com.earl.fishshop.base;

import java.util.List;

public interface BaseService<T> {

	Boolean save(T model);

	Boolean update(T t);

	Boolean deleteById(Long id);

	List<T> findAll();

//	List<T> pagefindAll(PageInfo pageInfo);

	T get(Long id);
	
	List<T> findByGivenCreteria(T object);
	
//	List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
}
