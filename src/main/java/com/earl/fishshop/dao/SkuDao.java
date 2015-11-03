package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.pojo.SkuPo;

public interface SkuDao extends BaseDao<SkuPo>{

	List<SkuPo> getSkuFromUnit(Long unitId);

}
