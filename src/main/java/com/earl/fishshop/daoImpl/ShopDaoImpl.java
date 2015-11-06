package com.earl.fishshop.daoImpl;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.ShopDao;
import com.earl.fishshop.pojo.ShopPo;


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
}