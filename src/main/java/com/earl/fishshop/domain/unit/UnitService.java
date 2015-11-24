package com.earl.fishshop.domain.unit;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.domain.sku.SkuPo;

public interface UnitService extends BaseService<UnitPo>{

	/**
	 * 得到指定单位下的规格列表
	 * @author 黄祥谦.
	 * @param unitId
	 * @return
	 */
	List<SkuPo> getSkuFromUnit(Long unitId);

}
