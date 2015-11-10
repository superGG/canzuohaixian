package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.ShipPortDao;
import com.earl.fishshop.pojo.ShipPortPo;
import com.earl.fishshop.service.ShipPortService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "shipPortService")
public class ShipPortServiceImpl extends BaseServiceImpl<ShipPortPo> implements
		ShipPortService {

	@Resource(name = "shipPortDao")
	ShipPortDao shipPortDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = shipPortDao;
	}
	
}
