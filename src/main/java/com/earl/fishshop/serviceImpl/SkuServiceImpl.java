package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.dao.SkuDao;
import com.earl.fishshop.pojo.SkuPo;
import com.earl.fishshop.service.SkuService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "skuService")
public class SkuServiceImpl extends BaseServiceImpl<SkuPo> implements
		SkuService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "skuDao")
	SkuDao skuDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = skuDao;
	}
	
}
