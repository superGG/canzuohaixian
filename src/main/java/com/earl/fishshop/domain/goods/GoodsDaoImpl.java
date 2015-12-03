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
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;
import com.google.gson.internal.LinkedTreeMap;


/**
 * 
 * 
 */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<GoodsPo> implements GoodsDao {

	@Override
	public void updateGoodPrice(@SuppressWarnings("rawtypes") List goodsList) {
		for (Object object : goodsList) {
			LinkedTreeMap goods = (LinkedTreeMap) object;
			Double object2 = (Double) goods.get("goodsId");
			Double object3 = (Double) goods.get("price");
			String hql = "update GoodsPo set price =:price where goodsId =:goodsId";
			getCurrentSession().createQuery(hql).setLong("goodsId", object2.longValue()).setDouble("price", object3).executeUpdate();
			
		}
	}

	@Override
	public void updateGoodNowNumber(List<GoodsPo> goodsList) {
		for (GoodsPo goodsPo : goodsList) {
		String hql = "update GoodsPo set nowNumber =:nowNumber where goodsId =:goodsId";
		getCurrentSession().createQuery(hql).setLong("goodsId",goodsPo.getGoodsId()).setDouble("nowNumber", goodsPo.getNowNumber()).executeUpdate();
		}
	}

	@Override
	public List<GoodsPo> getGoodsWithCategory(Long categoryId, PageInfo pageInfo) {
		String hql = "from GoodsPo where categoryId =:categoryId";
		@SuppressWarnings("unchecked")
		List<GoodsPo> goodsList = getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).setFirstResult((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize()).setMaxResults(pageInfo.getSize()).list();
		return goodsList;
	}

	@Override
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId, Integer indexPageNum, Integer size) {
//		select goodscategory,count(*),sum(nowNumber) from goods where shopId=1 group by goodscategory;
		//SQL语句测试过没有问题，需要组织返回的数据结构.
		String sql = "select categoryId,count(*),sum(nowNumber) from goods where shopId=:shopId group by categoryId";
		@SuppressWarnings("unchecked")
		List<Object[]> list = getCurrentSession().createSQLQuery(sql).setLong("shopId", shopId).setFirstResult((indexPageNum-1) * size).setMaxResults(size).list();
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

	@Override
	public void saveList(List<GoodsPo> arrayList) {
		// TODO 未测试.
		for (GoodsPo goodsPo : arrayList) {
			save(goodsPo);
		}
	}

	@Override
	public List<SkuPo> getPointCategoryGoodsInfo(Long shopId, Long categoryId) {
		// TODO 未测试.
		String hql = "from GoodsPo where shopId=:shopId and categoryId=:categoryId";
		@SuppressWarnings("unchecked")
		List<GoodsPo> list = getCurrentSession().createQuery(hql).setLong("shopId", shopId).setLong("categoryId", categoryId).list();
		ArrayList<SkuPo> arrayList = new ArrayList<SkuPo>();
		for (GoodsPo goodsPo : list) {
			SkuPo object = (SkuPo) getCurrentSession().get(SkuPo.class, goodsPo.getSku());
			object.setPrice(goodsPo.getPrice());
			object.setGoodsId(goodsPo.getGoodsId());
			arrayList.add(object);
		}
		return arrayList;
	}

	@Override
	public List<GoodsPo> getShopPointCategory(Long shopId, Long categoryId, Integer indexPageNum, Integer size) {
		// TODO 未测试.
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId)).add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<GoodsPo> goodsList = createCriteria.list();
		return goodsList;
	}

}