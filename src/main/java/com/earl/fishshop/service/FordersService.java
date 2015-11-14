package com.earl.fishshop.service;

import com.earl.fishshop.pojo.FordersPo;

public interface FordersService extends BaseService<FordersPo>{

	/**
	 * 添加购物车.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Long addForders(FordersPo model);

}
