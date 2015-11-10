package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.SkuPo;
import com.earl.fishshop.pojo.UnitPo;

public interface UnitService extends BaseService<UnitPo>{

	/**
	 * 得到指定单位下的规格列表
	 * @author 黄祥谦.
	 * @param unitId
	 * @return
	 */
	List<SkuPo> getSkuFromUnit(Long unitId);

}
