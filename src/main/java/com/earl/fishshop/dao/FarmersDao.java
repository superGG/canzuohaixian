package com.earl.fishshop.dao;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.FarmersPo;

public interface FarmersDao extends BaseDao<FarmersPo>{

	/**
	 * 用户验证为养殖户.
	 *@author 宋文光.
	 * @param userId
	 * @param model
	 */
	void authenticationFarmers(Long userId, FarmersPo model);

}
