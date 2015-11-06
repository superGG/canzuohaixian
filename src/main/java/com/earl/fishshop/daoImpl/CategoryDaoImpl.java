package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;


/**
 * 
 * 
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<CategoryPo> implements CategoryDao {
	// property constants
	
	@Override
	public List<CategoryPo> getHierarchyCategory() {
//		String hql = "from CategoryPo c left join fetch c.childCategory where c.parentId = 0";
		String hql = "select distinct c from CategoryPo c left join fetch c.childCategory where c.parentId = null";
		@SuppressWarnings("unchecked")
		List<CategoryPo> categoryList = getCurrentSession().createQuery(hql).list();
		return categoryList;
	}

	@Override
	public List<CategoryPo> getTopCategory() {
		String hql = "from CategoryPo c where c.parentId = null";
		@SuppressWarnings("unchecked")
		List<CategoryPo> categorylist = getCurrentSession().createQuery(hql).list();
		return categorylist;
	}

	@Override
	public List<CategoryPo> getNextLevelCategory(Long parentId) {
		String hql = "from CategoryPo c where c.parentId = :parentId";
		@SuppressWarnings("unchecked")
		List<CategoryPo> categorylist = getCurrentSession().createQuery(hql).setLong("parentId", parentId).list();
		return categorylist;
	}
}