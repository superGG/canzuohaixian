package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.vo.PageInfo;

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
	 * @param pageInfo TODO
	 * @param l
	 * @return
	 */
	List<CategoryPo> getNextLevelCategory(Long parentId, PageInfo pageInfo);

	/**
	 * 得到本月热门类别.
	 * 指定返回个数
	 * @author 黄祥谦.
	 * @param date TODO
	 * @param date2 
	 * @param showNumber TODO
	 * @return
	 */
	List<CategoryPo> getHotCategory(String date, String date2, Integer showNumber);

}
