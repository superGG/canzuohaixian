package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.dao.GetTypeDao;
import com.earl.fishshop.pojo.GetTypePo;

/**
 * 
 * 
 */
@Repository("getTypeDao")
public class GetTypeDaoImpl extends BaseDaoImpl<GetTypePo> implements GetTypeDao {
	
	@Override
	public List<GetTypePo> getNextLevelGetType(Long parentId) {
		String hql = "from GetTypePo c where c.parentId = :parentId";
		@SuppressWarnings("unchecked")
		List<GetTypePo> getTypeList = getCurrentSession().createQuery(hql).setLong("parentId", parentId).list();
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getTopGetType() {
		String hql = "from GetTypePo c where c.parentId = null";
		@SuppressWarnings("unchecked")
		List<GetTypePo> getTypeList = getCurrentSession().createQuery(hql).list();
		return getTypeList;
	}

	@Override
	public List<GetTypePo> getHierarchyGetType() {
		String hql = "select distinct c from GetTypePo c left join fetch c.childCategory where c.parentId = null";
		@SuppressWarnings("unchecked")
		List<GetTypePo> categoryList = getCurrentSession().createQuery(hql).list();
		return categoryList;
	}
}