package com.earl.fishshop.domain.goods;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.vo.PageInfo;


/**
 * 
 * 
 */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<GoodsPo> implements GoodsDao {

	@Override
	public void updateGoodPrice(Long goodsId, Double price) {
		String hql = "update GoodsPo set price =:price where goodsId =:goodsId";
		getCurrentSession().createQuery(hql).setLong("goodsId", goodsId).setDouble("price", price).executeUpdate();
	}

	@Override
	public void updateGoodNowNumber(Long goodsId, Long nowNumber) {
		String hql = "update GoodsPo set nowNumber =:nowNumber where goodsId =:goodsId";
		getCurrentSession().createQuery(hql).setLong("goodsId", goodsId).setDouble("nowNumber", nowNumber).executeUpdate();
	}

	@Override
	public List<GoodsPo> getGoodsWithCategory(Long categoryId, PageInfo pageInfo) {
		String hql = "from GoodsPo where categoryId =:categoryId";
		@SuppressWarnings("unchecked")
		List<GoodsPo> goodsList = getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).setFirstResult((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize()).setMaxResults(pageInfo.getSize()).list();
		return goodsList;
	}

	@Override
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId) {
//		select goodscategory,count(*),sum(nowNumber) from goods where shopId=1 group by goodscategory;
		//SQL语句测试过没有问题，需要组织返回的数据结构.
		String sql = "select categoryId,count(*),sum(nowNumber) from goods where shopId=:shopId group by categoryId";
		@SuppressWarnings("unchecked")
		List<Object[]> list = getCurrentSession().createSQLQuery(sql).setLong("shopId", shopId).list();
		List<CategoryPo> list2 = new ArrayList<CategoryPo>();
		for (Object[] category : list) {
			String hql2 = "from CategoryPo where categoryId =:categoryId";
			CategoryPo uniqueResult = (CategoryPo) getCurrentSession().createQuery(hql2).setLong("categoryId", ((BigInteger)category[0]).longValue()).uniqueResult();
				uniqueResult.setTotalNowNumber(((BigDecimal)category[2]).longValue());
				list2.add(uniqueResult);
		}
		return list2;
	}

	@Override
	public List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId)).add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<GoodsPo> goodsList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		
		return goodsList;
	}

	@Override
	public void deletePointCategoryGoods(Long categoryId, Long shopId) {
		String hql = "delete from GoodsPo where categoryId=:categoryId and shopId=:shopId";
		getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).setLong("shopId", shopId).executeUpdate();
		
	}

}