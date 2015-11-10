package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;

public interface GoodsDao extends BaseDao<GoodsPo>{

	/**
	 * 修改商品价格.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @param price
	 */
	void updateGoodPrice(Long goodsId, Double price);

	/**
	 * 更新商品数量.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @param nowNumber
	 */
	void updateGoodNowNumber(Long goodsId, Long nowNumber);

	/**
	 * 得到指定类别的商品.
	 * @author 黄祥谦.
	 * @param goodsCategory
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Integer goodsCategory);

	/**
	 * 已上架渔获.
	 * 得到类别分类，group by category.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	List<CategoryPo> getCategoryWithTotalNumber(Long shopId);

}
