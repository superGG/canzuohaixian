package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.service.OrdersService;

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
	public List<OrdersPo> getMyShopOrders(Long shopId) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getMyShopOrders(shopId);
		return ordersList;
	}
	
}
