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

	/**
	 * 得到未发货订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param pageInfo TODO
	 * @return
	 */
	List<OrdersPo> getUnSentOrders(Long userId, PageInfo pageInfo);

	/**
	 * 得到未支付订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param pageInfo
	 * @return
	 */
	List<OrdersPo> getUnpayOrders(Long userId, PageInfo pageInfo);

	/**
	 * 得到未支付订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param pageInfo
	 * @return
	 */
	List<OrdersPo> getUngetOrders(Long userId, PageInfo pageInfo);

	/**
	 * 得到未评论订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param pageInfo
	 * @return
	 */
	List<OrdersPo> getUnCommentOrders(Long userId, PageInfo pageInfo);

	/**
	 * 设置订单编号.
	 * @author 黄祥谦.
	 * @param orderId TODO
	 * @param orderNumber
	 * @return
	 */
	Boolean setOrderNumber(Long orderId, String orderNumber);

	

	
	
	
}
