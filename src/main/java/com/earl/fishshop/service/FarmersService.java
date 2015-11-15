package com.earl.fishshop.service;

import com.earl.fishshop.pojo.FarmersPo;

public interface FarmersService extends BaseService<FarmersPo>{

	/**
	 * 用户验证养殖户.
	 *@author 宋文光.
	 * @param userId
	 * @param model
	 * @return
	 */
	Boolean authenticationFarmer(Long userId, FarmersPo model);

	

	
	
	
}
