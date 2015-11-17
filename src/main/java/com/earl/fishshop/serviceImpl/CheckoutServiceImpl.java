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

	@Resource(name = "checkoutDao")
	CheckoutDao checkoutDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = checkoutDao;
	}

	@Override
	public Boolean passRecord(Long checkoutId) {
		try {
			checkoutDao.passRecord(checkoutId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean nopassRecord(Long checkoutId) {
		try {
			checkoutDao.nopassRecord(checkoutId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
