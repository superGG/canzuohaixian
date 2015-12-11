package com.earl.fishshop.domain.orders;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.pingplusplus.model.Charge;

public interface OrdersService extends BaseService<OrdersPo>{

	/**
	 * 得到指定商店的订单.
	 * @author 黄祥谦.
	 * @param indexPageNum TODO
	 * @param size TODO
	 */
	List<OrdersPo> getMyShopOrders(Long shopId, Integer indexPageNum, Integer size);

	/**
	 * 添加订单.
	 * @author 黄祥谦.
	 * @param model
	 * @param getAddressId TODO
	 * @return
	 */
	Boolean addOrders(OrdersPo model, Long getAddressId);

	/**
	 * 得到本次航海订单.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getOrdersWithSeaRecord(Long shopId, Integer indexPageNum, Integer size);

	/**
	 * 得到未发货订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getUnSentOrders(Long userId, Integer indexPageNum, Integer size);

	/**
	 * 得到未支付订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getUnpayOrders(Long userId, Integer indexPageNum, Integer size);

	/**
	 * 得到未支付订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getUngetOrders(Long userId, Integer indexPageNum, Integer size);

	/**
	 * 得到未评论订单.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getUnCommentOrders(Long userId, Integer indexPageNum, Integer size);

	/**
	 * 设置订单编号.
	 * @author 黄祥谦.
	 * @param orderId TODO
	 * @param orderNumber
	 * @return
	 */
	Boolean setOrderNumber(Long orderId, String orderNumber);

	/**
	 * 支付订单.
	 * @author 黄祥谦.
	 * @param ordersId
	 * @param channel TODO
	 * @return
	 */
	Charge payForOrders(Long ordersId, String channel);

	/**
	 * 修改订单状态为支付状态
	 * @author 黄祥谦.
	 * @param ordersId
	 * @return
	 */
	Boolean realPayOrders(Long ordersId);

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
	 * 得到运费计价方式.
	 * @author 黄祥谦.
	 * @param model
	 * @param getAddressId TODO
	 * @return
	 */
	Double getOrdersPostage(OrdersPo model, Long getAddressId);

	/**
	 * 得到指定订单详情.
	 * @author 黄祥谦.
	 * @param ordersId TODO
	 * @return
	 */
	OrdersPo getPointOrders(Long ordersId);

	/**
	 * 得到所有订单.
	 * @author 黄祥谦.
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<OrdersPo> getAllOrders(Integer indexPageNum, Integer size);

	/**
	 * 订单发货.
	 * @author 黄祥谦.
	 * @param ordersId
	 * @return
	 */
	Boolean realSendOrders(Long ordersId);

	/**
	 * 订单确认收货.
	 * @author 黄祥谦.
	 * @param ordersId
	 * @return
	 */
	Boolean realGetOrders(Long ordersId);

	/**
	 * 得到商家未发货订单.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param indexPageNum
	 * @param size
	 * @return
	 */
	List<OrdersPo> getShopUnSentOrders(Long shopId, Integer indexPageNum,
			Integer size);

	List<OrdersPo> getShopUnPayOrders(Long shopId, Integer indexPageNum,
			Integer size);

	List<OrdersPo> getShopUnGetOrders(Long shopId, Integer indexPageNum,
			Integer size);

	List<OrdersPo> getShopUnCommentOrders(Long shopId, Integer indexPageNum,
			Integer size);
}
