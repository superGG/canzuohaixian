package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.service.OrdersService;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.PageInfo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "ordersService")
public class OrdersServiceImpl extends BaseServiceImpl<OrdersPo> implements
		OrdersService {

	@Resource(name = "ordersDao")
	OrdersDao ordersDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = ordersDao;
	}

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId, PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getMyShopOrders(shopId, pageInfo);
		return ordersList;
	}

	@Override
	public Boolean addOrders(OrdersPo orders) {
		// TODO 未测试.
		try {
			ordersDao.addOrders(orders);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getOrdersWithSeaRecord(seaRecordId, pageInfo);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUnSentOrders(PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(MyConstant.order_unsent, pageInfo);
		return ordersList;
	}
	
	@Override
	public List<OrdersPo> getUnpayOrders(PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(MyConstant.order_unpay, pageInfo);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUngetOrders(PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(MyConstant.order_unget, pageInfo);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUnCommentOrders(PageInfo pageInfo) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(MyConstant.order_uncomment, pageInfo);
		return ordersList;
	}

	@Override
	public Boolean setOrderNumber(String orderNumber) {
		// TODO 未测试.
		try {
			
			ordersDao.setOrderNumber(null, orderNumber);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
