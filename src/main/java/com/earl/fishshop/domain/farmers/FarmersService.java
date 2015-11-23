package com.earl.fishshop.domain.farmers;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.vo.FarmersFileVo;

public interface FarmersService extends BaseService<FarmersPo>{

	/**
	 * 用户验证养殖户.
	 *@author 宋文光.
	 * @param userId
	 * @param model
	 * @param farmersFileVo 
	 * @return
	 */
	Boolean authenticationFarmer(Long userId, FarmersPo model, FarmersFileVo farmersFileVo);

	/**
	 * 查询养殖户的详细信息.
	 *@author 宋文光.
	 * @param identityId
	 * @return
	 */
	List<FarmersPo> getFarmers(Long identityId);

	
	/**
	 *  通过养殖户认证.
	 *@author 宋文光.
	 * @param userId
	 * @return
	 */
	Boolean passAuthenticationFarmers(Long userId);

	/**
	 * 不通过养殖认证.
	 *@author 宋文光.
	 * @param userId
	 * @param farmersId
	 * @return
	 */
	Boolean noPassAuthenticationFarmers(Long userId, Long farmersId);
	
	
	
}
