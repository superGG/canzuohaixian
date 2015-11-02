package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.BaseDao;
import com.earl.fishshop.pojo.GetTypePo;
import com.earl.fishshop.service.GetTypeService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "getTypeService")
public class GetTypeServiceImpl extends BaseServiceImpl<GetTypePo> implements
		GetTypeService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "getTypeDao")
	BaseDao getTypeDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = getTypeDao;
	}
	
}
