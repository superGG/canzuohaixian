package com.earl.fishshop.domain.goods;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.vo.PageInfo;

public interface GoodsService extends BaseService<GoodsPo>{

	/**
	 * 修改商品价格.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @param price
	 * @return
	 */
	Boolean updateGoodPrice(Long goodsId, Double price);

	/**
	 * 修改商品数量.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @param nowNumber
	 * @return
	 */
	Boolean updateGoodNowNumber(Long goodsId, Long nowNumber);

	/**
	 * 通过商品类别得到指定商品.
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param pageInfo 
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Long categoryId, PageInfo pageInfo);

	/**
	 * 得到用户发布的该类别下的商品总量
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	List<CategoryPo> getCategoryWithTotalNumber(Long shopId);

	/**
	 * 得到商家发布的所有商品，数量为零的不显示
	 * @author 黄祥谦.
	 * @param shopId
	 * @param pageInfo 
	 * @return
	 */
	List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo);

	/**
	 * 得到商品详情.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @return
	 */
	GoodsPo getGoodsInfo(Long goodsId);

	/**
	 * 删除指定商店的特定类别渔货
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param shopId
	 * @return
	 */
	Boolean deletePointCategoryGoods(Long categoryId, Long shopId);

}
