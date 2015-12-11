package com.earl.fishshop.domain.region;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
@Service(value = "regionService")
public class RegionServiceImpl extends BaseServiceImpl<RegionPo> implements
		RegionService {

	@Resource(name = "regionDao")
	RegionDao regionDao;

	@PostConstruct
	public void initBaseDao() {
		baseDao = regionDao;
	}
}
