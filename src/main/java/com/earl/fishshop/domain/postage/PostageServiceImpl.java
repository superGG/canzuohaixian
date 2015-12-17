package com.earl.fishshop.domain.postage;

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
 @Service(value = "postageService")
public class PostageServiceImpl extends BaseServiceImpl<PostagePo> implements
		PostageService {

	@Resource(name = "postageDao")
	PostageDao postageDao;

//	@PreDestroy(对象销毁前)
	@PostConstruct//在构造函数之后执行.
	public void initBaseDao(){
		baseDao = postageDao;
	}

	@Override
	public List<PostagePo> findAllPostage() {
		// TODO 未测试.
		List<PostagePo> findAll = postageDao.findAll();
		for (PostagePo postagePo : findAll) {
			RegionPo org = regionDao.get(Long.valueOf(postagePo.getOrigin()));
			RegionPo des = regionDao.get(Long.valueOf(postagePo.getDestination()));
			postagePo.setOrigin(org.getName());
			postagePo.setDestination(des.getName());
		}
		return findAll;
	}

}
