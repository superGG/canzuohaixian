package com.earl.fishshop.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
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
		// TODO 未测试.
		String hql = "update GoodsPo set nowNumber =:nowNumber where goodsId =:goodsId";
		getCurrentSession().createQuery(hql).setLong("goodsId", goodsId).setDouble("nowNumber", nowNumber).executeUpdate();
	}

	@Override
	public List<GoodsPo> getGoodsWithCategory(Long categoryId) {
		// TODO 未测试.
		String hql = "from GoodsPo where categoryId =:categoryId";
		@SuppressWarnings("unchecked")
		List<GoodsPo> goodsList = getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).list();
		return goodsList;
	}

	@Override
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId) {
		// TODO 未测试.
//		select goodscategory,count(*),sum(nowNumber) from goods where shopId=1 group by goodscategory;
		//SQL语句测试过没有问题，需要组织返回的数据结构.
		String sql = "select categoryId,count(*),sum(nowNumber) from goods where shopId=：shopId group by categoryId";
		List list = getCurrentSession().createSQLQuery(sql).setLong("shopId", shopId).list();
		return list;
	}

	@Override
	public List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo) {
		// TODO 未测试.
		
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId)).add(Restrictions.gt("nowNumber", 0));
		
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

}