package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.vo.PageInfo;

public interface OrdersDao extends BaseDao<OrdersPo>{

	/**
	 * 得到指定商店的订单.
	 * @author 黄祥谦.
	 * @param pageInfo TODO
	 */
	List<OrdersPo> getMyShopOrders(Long shopId, PageInfo pageInfo);

	/**
	 * 更新订单状态.
	 * @author 黄祥谦.
	 * @param ordersId TODO
	 * @param state TODO
	 */
	void updateOrdersState(Long ordersId, Integer state);

	/**
	 * 添加订单.
	 * @author 黄祥谦.
	 * @param orders
	 */
	void addOrders(OrdersPo orders);

	/**
	 * 得到本次出航订单.
	 * @author 黄祥谦.
	 * @param seaRecordId
	 * @param pageInfo TODO
	 * @return
	 */
	List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo);

}
