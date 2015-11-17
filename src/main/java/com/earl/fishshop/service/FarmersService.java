package com.earl.fishshop.service;

import java.util.List;

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

	/**
	 * 查询养殖户的详细信息.
	 *@author 宋文光.
	 * @param identityId
	 * @return
	 */
	List<FarmersPo> getFarmers(Long identityId);

	

	
	
	
}
