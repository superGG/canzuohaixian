package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.FordersDao;
import com.earl.fishshop.pojo.FordersPo;
import com.earl.fishshop.service.FordersService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "fordersService")
public class FordersServiceImpl extends BaseServiceImpl<FordersPo> implements
		FordersService {

	@Resource(name = "fordersDao")
	FordersDao fordersDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = fordersDao;
	}

	@Override
	public Long addForders(FordersPo forder) {
		// TODO 未测试.
		Long fordersId = fordersDao.addForders(forder);
		return fordersId;
	}

}
