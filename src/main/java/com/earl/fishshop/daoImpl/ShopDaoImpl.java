package com.earl.fishshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.ShopDao;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.vo.PageInfo;


/**
 * 
 * 
 */
@Repository("shopDao")
public class ShopDaoImpl extends BaseDaoImpl<ShopPo> implements ShopDao {
	
	@Override
	public ShopPo getMyShop(Long userId) {
		// TODO 未测试.
		String hql = "from ShopPo where userId = :userId";
		ShopPo shop = (ShopPo)getCurrentSession().createQuery(hql).setLong("userId", userId).uniqueResult();
		return shop;
	}

	@Override
	public void updateSentPrice(Long shopId, Double sendPrice) {
		// TODO 未测试.
		String hql = "update ShopPo set sendPrice = :sendPrice where shopId = :shopId";
		getCurrentSession().createQuery(hql).setLong("shopId", shopId).setDouble("sendPrice", sendPrice).executeUpdate();
	}

	@Override
	public List<ShopPo> getGoodsShops(Long categoryId, PageInfo pageInfo) {
		// TODO 未测试.
		Criteria createCriteria = getCurrentSession().createCriteria(GoodsPo.class);
		createCriteria.add(Restrictions.eq("categoryId", categoryId));
		createCriteria.add(Restrictions.gt("nowNumber", 0L));
		createCriteria.setProjection(Projections.property("shopId"));
		createCriteria.setProjection(Projections.groupProperty("shopId"));
		
		@SuppressWarnings("unchecked")
		List<Long> list = createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize()).list();
		List<ShopPo> shopList = new ArrayList<ShopPo>();
		  Long size = (Long) createCriteria.setProjection(Projections.rowCount())
	                .uniqueResult();
		pageInfo.setTotalCount(size);
		
		for (Long shopId : list) {
			String hql2 = "from ShopPo where shopId = :shopId";
			ShopPo tmpShop = (ShopPo) getCurrentSession().createQuery(hql2).setLong("shopId", shopId).uniqueResult();
			shopList.add(tmpShop);
		}
		return shopList;
	}
}