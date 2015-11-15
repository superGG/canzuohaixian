package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.FishmanPo;

public interface FishmanDao extends BaseDao<FishmanPo>{

	/**
	 * 认证用户为渔户.
	 * @author 黄祥谦.
	 * @param userId
	 * @param model
	 */
	void authenticationFishman(Long userId, FishmanPo fishman);

	/**
	 * 查询渔户详细信息.
	 *@author 宋文光.
	 * @param identityId 渔户的id.
	 * @return
	 */
	List<FishmanPo> getFishman(Long identityId);

}
