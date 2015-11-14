package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;


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

}