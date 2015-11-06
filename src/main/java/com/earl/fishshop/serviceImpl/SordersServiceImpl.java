package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.dao.SordersDao;
import com.earl.fishshop.pojo.SordersPo;
import com.earl.fishshop.service.SordersService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "sordersService")
public class SordersServiceImpl extends BaseServiceImpl<SordersPo> implements
		SordersService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "sordersDao")
	SordersDao sordersDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = sordersDao;
	}
	
}
