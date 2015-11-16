package com.earl.fishshop.service;

import com.earl.fishshop.pojo.ShopPo;

public interface ShopService extends BaseService<ShopPo>{

	/**
	 * 得到我的商店.
	 * @author 黄祥谦.
	 * @param userId 用户id
	 * @return
	 */
	ShopPo getMyShop(Long userId);

	/**
	 * 更新起送价格.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param sendPrice TODO
	 * @return
	 */
	Boolean updateSentPrice(Long shopId, Double sendPrice);

	/**
	 * 添加商店信息.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addShop(ShopPo model);

	/**
	 * 停止航行.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	Boolean endSeaing(Long shopId);

}
