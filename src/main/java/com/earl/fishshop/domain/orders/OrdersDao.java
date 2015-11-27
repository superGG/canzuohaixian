package com.earl.fishshop.domain.orders;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;
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
	 * @param getAddressId TODO
	 */
	void addOrders(OrdersPo orders, Long getAddressId);

	/**
	 * 得到本次出航订单.
	 * @author 黄祥谦.
	 * @param seaRecordId
	 * @param pageInfo TODO
	 * @return
	 */
	List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo);

	/**
	 * 得到未发货订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param state TODO
	 * @param pageInfo TODO
	 * @return
	 */
	List<OrdersPo> getPointStateOrders(Long userId, Integer state, PageInfo pageInfo);

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
	 * @param pageInfo
	 * @return
	 */
	List<OrdersPo> getAllUserOrders(Long userId, PageInfo pageInfo);

	/**
	 * 得到邮费.
	 * @author 黄祥谦.
	 * @param ordersDetail
	 * @param provinceId
	 * @return
	 */
	Double getOrdersPostage(List<OrdersDetailPo> ordersDetail, Long provinceId);

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

}
