package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.BaseDao;
import com.earl.fishshop.pojo.FarmersPo;
import com.earl.fishshop.service.FarmersService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "farmersService")
public class FarmersServiceImpl extends BaseServiceImpl<FarmersPo> implements
		FarmersService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "farmersDao")
	BaseDao farmersDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = farmersDao;
	}
	
}
