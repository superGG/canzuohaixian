package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.service.GoodsService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<GoodsPo> implements
		GoodsService {

	@Resource(name = "goodsDao")
	GoodsDao goodsDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = goodsDao;
	}
	
}
