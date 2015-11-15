package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.FishmanPo;

public interface FishmanService extends BaseService<FishmanPo>{

	/**
	 * 验证用户为渔户.
	 * @author 黄祥谦.
	 * @param userId 用户id.
	 * @param model 渔户详细信息.
	 * @return
	 */
	Boolean authenticationFishman(Long userId, FishmanPo model);

	/**
	 * 查询渔户详细信息.
	 *@author 宋文光.
	 * @param identityId 渔户的id.
	 * @return
	 */
	List<FishmanPo> getFishman(Long identityId);

	

	
	
	
}
