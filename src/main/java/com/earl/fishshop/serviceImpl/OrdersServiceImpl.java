package com.earl.fishshop.serviceImpl;

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
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "ordersDao")
	OrdersDao ordersDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = ordersDao;
	}
	
}
