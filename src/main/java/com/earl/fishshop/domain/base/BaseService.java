package com.earl.fishshop.domain.base;

import java.util.List;

import com.earl.fishshop.vo.PageInfo;

public interface BaseService<T> {

	Boolean save(T model);

	Boolean update(T t);
	
	Boolean updateWithNotNullProperties(T t);

	Boolean deleteById(Long id);

	List<T> findAll();
	
	List<T> findAll(PageInfo pageInfo);

//	List<T> pagefindAll(PageInfo pageInfo);

	T get(Long id);
	
	List<T> findByGivenCreteria(T object);
	
//	List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
}
