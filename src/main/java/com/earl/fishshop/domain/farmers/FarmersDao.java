package com.earl.fishshop.domain.farmers;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

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

	/**
	 * 通过商店获取养殖户信息
	 *@author 宋文光.
	 * @param shopId
	 * @return
	 */
	List<FarmersPo> getFarmerBy1Shop(Long shopId);

	
}
