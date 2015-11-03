package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.CategoryPo;

public interface CategoryService extends BaseService<CategoryPo>{

	/**
	 * 得到带层次级别的类别.
	 * @author 黄祥谦.
	 * @return
	 */
	List<CategoryPo> getHierarchyCategory();

	

	
	
	
}
