package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.vo.PageInfo;

public interface OrdersService extends BaseService<OrdersPo>{

	/**
	 * 得到指定商店的订单.
	 * @author 黄祥谦.
	 * @param pageInfo TODO
	 */
	List<OrdersPo> getMyShopOrders(Long shopId, PageInfo pageInfo);

	/**
	 * 添加订单.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addOrders(OrdersPo model);

	/**
	 * 得到本次航海订单.
	 * @author 黄祥谦.
	 * @param seaRecordId
	 * @param pageInfo TODO
	 * @return
	 */
	List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo);

	

	
	
	
}
