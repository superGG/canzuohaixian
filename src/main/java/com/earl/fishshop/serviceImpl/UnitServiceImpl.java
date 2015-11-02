package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.BaseDao;
import com.earl.fishshop.pojo.UnitPo;
import com.earl.fishshop.service.UnitService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "unitService")
public class UnitServiceImpl extends BaseServiceImpl<UnitPo> implements
		UnitService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "unitDao")
	BaseDao unitDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = unitDao;
	}
	
}
