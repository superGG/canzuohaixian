package com.earl.fishshop.domain.fishman;

import java.util.List;

import com.earl.fishshop.base.BaseService;
import com.earl.fishshop.vo.FishmanFileVo;

public interface FishmanService extends BaseService<FishmanPo>{

	/**
	 * 验证用户为渔户.
	 * @author 黄祥谦.
	 * @param userId 
	 * @param model 渔户详细信息.
	 * @param fishmanFileVo 图片信息.
	 * @return
	 */
	Boolean authenticationFishman(Long userId, FishmanPo model, FishmanFileVo fishmanFileVo);

	/**
	 * 查询渔户详细信息.
	 *@author 宋文光.
	 * @param identityId 渔户的id.
	 * @return
	 */
	List<FishmanPo> getFishman(Long identityId);

	/**
	 * 通过渔户认证.
	 *@author 宋文光.
	 * @param userId
	 * @return
	 */
	Boolean passAuthenticationFishman(Long userId);

	/**
	 * 不通过渔户认证.
	 *@author 宋文光.
	 * @param userId 用户id
	 * @param fishmanId 渔户id
	 * @return
	 */
	Boolean noPassAuthenticationFishman(Long userId, Long fishmanId);

	

	

	
	
	
}
