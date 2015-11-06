package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.dao.GetTypeDao;
import com.earl.fishshop.pojo.GetTypePo;
import com.earl.fishshop.service.GetTypeService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "getTypeService")
public class GetTypeServiceImpl extends BaseServiceImpl<GetTypePo> implements
		GetTypeService {

	@Resource(name = "getTypeDao")
	GetTypeDao getTypeDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = getTypeDao;
	}

	@Override
	public List<GetTypePo> getNextLevelGetType(Long parentId) {
		// TODO 未测试.
		List<GetTypePo> getTypeList = getTypeDao.getNextLevelGetType(parentId);
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getTopGetType() {
		// TODO 未测试.
		List<GetTypePo> getTypeList = getTypeDao.getTopGetType();
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getHierarchyGetType() {
		// TODO 未测试.
		List<GetTypePo> getTypeList = getTypeDao.getHierarchyGetType();
		return getTypeList;
	}
	
}
