package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.CheckoutDao;
import com.earl.fishshop.pojo.CheckoutPo;
import com.earl.fishshop.service.CheckoutService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "checkoutService")
public class CheckoutServiceImpl extends BaseServiceImpl<CheckoutPo> implements
		CheckoutService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "checkoutDao")
	CheckoutDao checkoutDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = checkoutDao;
	}
	
}
