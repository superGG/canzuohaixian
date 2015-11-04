package com.earl.fishshop.dao;

import com.earl.fishshop.pojo.FishmanPo;

public interface FishmanDao extends BaseDao<FishmanPo>{

	/**
	 * 认证用户为渔户.
	 * @author 黄祥谦.
	 * @param userId
	 * @param model
	 */
	void authenticationFishman(Long userId, FishmanPo fishman);

}
