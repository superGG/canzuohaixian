package com.earl.fishshop.domain.unit;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.sku.SkuPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "unitService")
public class UnitServiceImpl extends BaseServiceImpl<UnitPo> implements
		UnitService {

	@Resource(name = "unitDao")
	UnitDao unitDao;

//	@PreDestroy(对象销毁前)
	@PostConstruct//在构造函数之后执行.
	public void initBaseDao(){
		baseDao = unitDao;
	}

	@Override
	public List<SkuPo> getSkuFromUnit(Long unitId) {
		List<SkuPo> skuList = skuDao.getSkuFromUnit(unitId);
		return skuList;
	}
	
}
