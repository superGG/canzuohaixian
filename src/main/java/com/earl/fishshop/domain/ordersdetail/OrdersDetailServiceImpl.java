package com.earl.fishshop.domain.ordersdetail;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;

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
