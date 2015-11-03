package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.CategoryPo;

public interface CategoryService extends BaseService<CategoryPo>{

	List<CategoryPo> getHierarchyCategory();

	

	
	
	
}
