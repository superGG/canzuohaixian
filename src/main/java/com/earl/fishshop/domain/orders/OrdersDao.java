package com.earl.fishshop.domain.orders;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;

public interface OrdersDao extends BaseDao<OrdersPo>{

	/**
	 * 得到指定商店的订单.
	 * @author 黄祥谦.
	 * @param indexPageNum 
	 * @param size TODO
	 */
	List<OrdersPo> getMyShopOrders(Long shopId, Integer indexPageNum, Integer size);

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
	 * @param getAddressId 
	 */
	void addOrders(OrdersPo orders, Long getAddressId);

	/**
	 * 得到本次出航订单.
	 * @author 黄祥谦.
	 * @param seaRecordId
	 * @param indexPageNum 
	 * @param size 
	 * @return
	 */
	List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, Integer indexPageNum, Integer size);

	/**
	 * 得到用户指定状态订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param state TODO
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getPointStateOrders(Long userId, Integer state, Integer indexPageNum, Integer size);
	
	/**
	 * 得到商家指定状态订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param state TODO
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getShopPointStateOrders(Long shopId, Integer state, Integer indexPageNum, Integer size);

	/**
	 * 设置订单编号.
	 * @author 黄祥谦.
	 * @param ordersId TODO
	 * @param orderNumber
	 */
	void setOrderNumber(Long ordersId, String orderNumber);

	/**
	 * 得到用户所有订单.
	 * @author 黄祥谦.
	 * @param userId
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getAllUserOrders(Long userId, Integer indexPageNum, Integer size);

	/**
	 * 得到邮费.
	 * @author 黄祥谦.
	 * @param weight TODO
	 * @param firstWeight TODO
	 * @param increasePrice TODO
	 * @return
	 */
	Double getOrdersPostage(Double weight, Double firstWeight, Double increasePrice);

	/**
	 * 更新订单.
	 *@author 宋文光.
	 * @param order
	 */
	void updateOrder(OrdersPo order);

	/**
	 * 得到指定订单详情.
	 * @author 黄祥谦.
	 * @param ordersId
	 * @return
	 */
	OrdersPo getPointOrders(Long ordersId);

	/**
	 * 得到所有订单.
	 * @author 黄祥谦.
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getAllOrders(Integer indexPageNum, Integer size);

	/**
	 * 得到订单项的总质量.
	 * @author 黄祥谦.
	 * @param ordersDetail
	 * @return
	 */
	Double getWeight(List<OrdersDetailPo> ordersDetail);

}
