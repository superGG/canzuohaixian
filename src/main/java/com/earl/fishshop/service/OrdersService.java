package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.OrdersPo;

public interface OrdersService extends BaseService<OrdersPo>{

	/**
	 * 得到指定商店的订单.
	 * @author 黄祥谦.
	 */
	List<OrdersPo> getMyShopOrders(Long shopId);

	

	
	
	
}
