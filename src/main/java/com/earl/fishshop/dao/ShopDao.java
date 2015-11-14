package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.vo.PageInfo;

public interface ShopDao extends BaseDao<ShopPo>{

	/**
	 * 得到我的商店.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @return
	 */
	ShopPo getMyShop(Long userId);

	/**
	 * 更新起送价格.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param sendPrice TODO
	 */
	void updateSentPrice(Long shopId, Double sendPrice);

	/**
	 * 得到商店
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getGoodsShops(Long categoryId, PageInfo pageInfo);

}
