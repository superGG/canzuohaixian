package com.earl.fishshop.dao;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.FordersPo;

public interface FordersDao extends BaseDao<FordersPo>{

	/**
	 * 添加购物车.
	 * @author 黄祥谦.
	 * @param forder
	 * @return
	 */
	Long addForders(FordersPo forder);

}
