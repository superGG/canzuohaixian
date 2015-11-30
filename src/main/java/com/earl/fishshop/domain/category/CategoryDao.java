package com.earl.fishshop.domain.category;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;
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
	 * @param pageInfo 分页对象.
	 * @param l
	 * @return
	 */
	List<CategoryPo> getNextLevelCategory(Long parentId, PageInfo pageInfo);

	/**
	 * 得到本月热门类别.
	 * 指定返回个数
	 * @author 黄祥谦.
	 * @param date 日期对象
	 * @param date2 
	 * @param showNumber 
	 * @return
	 */
	List<CategoryPo> getHotCategory(String date, String date2, Integer showNumber);

	/**
	 * 添加类别.
	 * @author 黄祥谦.
	 * @param model
	 */
	void addCategory(CategoryPo model);

	/**
	 * 得到带规格的类别
	 * @author 黄祥谦.
	 * @param categoryId
	 * @return
	 */
	CategoryPo getCategoryWithSku(Long categoryId);

	/**
	 * 更新类别信息.
	 * @author 黄祥谦.
	 * @param model
	 */
	void updateCategory(CategoryPo model);

	/**
	 * 得到所有二级分类.
	 * @author 黄祥谦.
	 * @return
	 */
	List<CategoryPo> getAllNextLevelCategory();

}
