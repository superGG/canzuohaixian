package com.earl.fishshop.dao;

import java.util.List;

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

	/**
	 * 查询养殖户的详细信息.
	 *@author 宋文光.
	 * @param identityId
	 * @return
	 */
	List<FarmersPo> getFarmers(Long identityId);

	/**
	 * 通过养殖户认证.
	 *@author 宋文光.
	 * @param userId
	 */
	void passAuthenticationFarmers(Long userId);

	/**
	 * 不通过养殖户认证.
	 *@author 宋文光.
	 * @param userId
	 */
	void noPassAuthenticationFarmers(Long userId);
}
