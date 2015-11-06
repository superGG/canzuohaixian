package com.earl.fishshop.dao;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.ShopPo;

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

}
