package com.earl.fishshop.domain.shipport;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;

public interface ShipPortService extends BaseService<ShipPortPo>{
 
	/**
	 * 查询所有停港地点.
	 * @author 黄祥谦.
	 * @return
	 */
	List<ShipPortPo> findAllShipPort();

	

	
	
	
}
