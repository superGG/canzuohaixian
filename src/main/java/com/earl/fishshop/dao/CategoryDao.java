package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.pojo.CategoryPo;

public interface CategoryDao extends BaseDao<CategoryPo>{

	/**
	 * 得到带有层次结构的类别
	 * @author 黄祥谦.
	 * @return
	 */
	List<CategoryPo> getHierarchyCategory();

	/**
	 * 得到顶层类别.
	 * @author 黄祥谦.
	 * @return 顶层类别对象.
	 */
	List<CategoryPo> getTopCategory();

	/**
	 * 得到下一级的类别.
	 * @author 黄祥谦.
	 * @param l
	 * @return
	 */
	List<CategoryPo> getNextLevelCategory(Long parentId);

}
