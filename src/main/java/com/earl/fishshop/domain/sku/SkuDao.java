package com.earl.fishshop.domain.sku;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.SkuPo;

public interface SkuDao extends BaseDao<SkuPo>{

	/**
	 * 得到对应单位下的规格.
	 * @author 黄祥谦.
	 * @param unitId 单位Id.
	 * @return
	 */
	List<SkuPo> getSkuFromUnit(Long unitId);

}
