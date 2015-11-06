package com.earl.fishshop.service;

import com.earl.fishshop.base.BaseService;
import com.earl.fishshop.pojo.ShopPo;

public interface ShopService extends BaseService<ShopPo>{

	/**
	 * 得到我的商店.
	 * @author 黄祥谦.
	 * @param userId 用户id
	 * @return
	 */
	ShopPo getMyShop(Long userId);

	

	
	
	
}
