package com.earl.fishshop.daoImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.vo.PageInfo;


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
	public List<CategoryPo> getNextLevelCategory(Long parentId, PageInfo pageInfo) {
		
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("parentId", parentId));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());

		@SuppressWarnings("unchecked")
		List<CategoryPo> categorylist = createCriteria.list();
		for (CategoryPo categoryPo : categorylist) {
			String hql = "select min(price) from GoodsPo where categoryId = :categoryId";
			Double uniqueResult = (Double) getCurrentSession().createQuery(hql).setLong("categoryId", categoryPo.getCategoryId()).uniqueResult();
			categoryPo.setLowPrice(uniqueResult);
		}
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
	                .uniqueResult();
		pageInfo.setTotalCount(size);
		
		return categorylist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryPo> getHotCategory(String date,String date2, Integer showNumber) {
		// TODO 未测试.
//		SELECT COUNT(*) AS total FROM `logs` WHERE FROM_UNIXTIME(`create_time`,'%Y-%m')='2015-06'
//		String hql = "select categoryId,sum(number) as hotDegree from SordersPo where createTime>:date  order by number group by categoryId limit 0,:showNumber";
		String hql = "select categoryId,sum(number) as hotdegree from ordersdetail where createTime >:date and createTime < :date2 group by categoryId order by number limit 0,:showNumber";
		List<Object[]> list = getCurrentSession().createSQLQuery(hql).setString("date", date).setString("date2", date2).setInteger("showNumber", showNumber).list();
		List<CategoryPo> list2 = new ArrayList<CategoryPo>();
		for (Object[] category : list) {
			String hql2 = "from CategoryPo where categoryId =:categoryId";
			CategoryPo uniqueResult = (CategoryPo) getCurrentSession().createQuery(hql2).setLong("categoryId", ((BigInteger)category[0]).longValue()).uniqueResult();
				uniqueResult.setHotDegree(((BigDecimal)category[1]).longValue());
				list2.add(uniqueResult);
		}
		return list2;
	}
}