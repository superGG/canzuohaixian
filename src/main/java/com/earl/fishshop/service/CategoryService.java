package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.base.BaseService;
import com.earl.fishshop.pojo.CategoryPo;

public interface CategoryService extends BaseService<CategoryPo>{

	/**
	 * 得到带层次级别的类别.
	 * @author 黄祥谦.
	 * @return
	 */
	List<CategoryPo> getHierarchyCategory();

	/**
	 * 得到顶层的类别.
	 * @author 黄祥谦.
	 * @return
	 */
	List<CategoryPo> getTopCategory();

	/**
	 * 得到指定类别的下一级类别.
	 * @author 黄祥谦.
	 * @param parentId 指定的父类别id.
	 * @return
	 */
	List<CategoryPo> getNextLevelCategory(Long parentId);

	

	
	
	
}
