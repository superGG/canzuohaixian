package com.earl.fishshop.domain.gettype;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.helper.JsonHelper;

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
	public void initBaseDao() {
		baseDao = getTypeDao;
	}

	@Override
	public List<GetTypePo> getNextLevelGetType(Long parentId) {
		List<GetTypePo> getTypeList = getTypeDao.getNextLevelGetType(parentId);
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getTopGetType() {
		List<GetTypePo> getTypeList = getTypeDao.getTopGetType();
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getHierarchyGetType() {
		List<GetTypePo> getTypeList = getTypeDao.getHierarchyGetType();
		return getTypeList;
	}

	public String getGetTypeName(String getType) {
		List<String> getTypeNameList = new ArrayList<String>();
		List<String> idList = getTypeToList(getType);
		for (String id : idList) {
			Long getTypeId = Long.parseLong(id);
//			System.out.println(getTypeId);
			GetTypePo get = getTypeDao.get(getTypeId);
			getTypeNameList.add(get.getGetName());
//			System.out.println(get.getGetName());
		}
		String getTypeName = JsonHelper.toJson(getTypeNameList);
		System.out.println(getTypeName);
		return getTypeName;
	}

	private List<String> getTypeToList(String getType) {
		List<String> idList = new ArrayList<String>();
		
		StringBuffer jsonBuffer = new StringBuffer(getType.trim());
		jsonBuffer.deleteCharAt(jsonBuffer.indexOf("["));
		jsonBuffer.deleteCharAt(jsonBuffer.lastIndexOf("]"));
		String tempJson = jsonBuffer.toString()+",";
		
		StringTokenizer stMsg = new StringTokenizer(tempJson, ",");

		idList.add(stMsg.nextToken());
		while (stMsg.hasMoreTokens()) {
			idList.add(stMsg.nextToken());
		}
		return idList;
	}
}
