package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.pojo.ShopPo;
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
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Long categoryId);

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
	 * @param pageInfo TODO
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

}
