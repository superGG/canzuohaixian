package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.OrdersDetailDao;
import com.earl.fishshop.pojo.OrdersDetailPo;
import com.earl.fishshop.service.OrdersDetailService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "ordersDetailService")
public class OrdersDetailServiceImpl extends BaseServiceImpl<OrdersDetailPo> implements
		OrdersDetailService {

	@Resource(name = "ordersDetailDao")
	OrdersDetailDao ordersDetailDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = ordersDetailDao;
	}
	
}
