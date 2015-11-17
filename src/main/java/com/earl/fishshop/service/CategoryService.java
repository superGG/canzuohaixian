package com.earl.fishshop.service;

import java.util.List;
import java.util.Map;

import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.vo.PageInfo;

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
	 * @param pageInfo TODO
	 * @return
	 */
	List<CategoryPo> getNextLevelCategory(Long parentId, PageInfo pageInfo);

	/**
	 * 得到本月热门类别.
	 * @author 黄祥谦.
	 * @param application 
	 * @return
	 */
	List<CategoryPo> getHotCategory(Map<String, Object> application);

	/**
	 * 得到发布该种类商品的商店.
	 * @author 黄祥谦.
	 * @param categoryId TODO
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getGoodsShops(Long categoryId, PageInfo pageInfo);

	/**
	 * 野生产品
	 * 得到该类别下的渔户商家的信息.
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getGoodsFishShops(Long categoryId, PageInfo pageInfo);
	
	/**
	 * 养殖产品
	 * 得到该类别下的养殖户商家的信息.
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getGoodsFarmerShops(Long categoryId, PageInfo pageInfo);


	
	
	
}
