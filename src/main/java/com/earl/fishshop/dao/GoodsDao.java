package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.vo.PageInfo;

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
	 * 得到商家指定类别的商品.
	 * @author 黄祥谦.
	 * @param goodsCategory
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Long goodsCategory);

	/**
	 * 已上架渔获.
	 * 得到类别分类，group by category.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	List<CategoryPo> getCategoryWithTotalNumber(Long shopId);
	
	/**
	 * 得到商家发布的所有商品，数量为零的不显示
	 * @author 黄祥谦.
	 * @param shopId
	 * @param pageInfo TODO
	 * @return
	 */
	List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo);

	/**
	 * 删除指定商店的特定类别渔货
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param shopId
	 * @return
	 */
	void deletePointCategoryGoods(Long categoryId, Long shopId);

}
