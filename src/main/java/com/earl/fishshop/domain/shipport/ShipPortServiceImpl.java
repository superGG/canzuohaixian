package com.earl.fishshop.domain.shipport;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.region.RegionPo;

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

	@Override
	public List<ShipPortPo> findAllShipPort() {
		// TODO 未测试.
		List<ShipPortPo> shipportList = shipPortDao.findAll();
		for (ShipPortPo shipPortPo : shipportList) {
			RegionPo regionPo = regionDao.get(Long.valueOf(shipPortPo.getAddresscode()));
			shipPortPo.setProvinceName(regionPo.getName());
		}
		return shipportList;
	}
	
}
