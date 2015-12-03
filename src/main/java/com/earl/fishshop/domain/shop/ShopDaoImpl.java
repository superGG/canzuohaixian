package com.earl.fishshop.domain.shop;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.vo.PageInfo;

/**
 * 
 * 
 */
@Repository("shopDao")
public class ShopDaoImpl extends BaseDaoImpl<ShopPo> implements ShopDao {

	@Override
	public ShopPo getMyShop(Long userId) {
		String hql = "from ShopPo where userId = :userId";
		ShopPo shop = (ShopPo) getCurrentSession().createQuery(hql)
				.setLong("userId", userId).uniqueResult();
		return shop;
	}

	@Override
	public void updateSentPrice(Long shopId, Double sendPrice) {
		String hql = "update ShopPo set sendPrice = :sendPrice where shopId = :shopId";
		getCurrentSession().createQuery(hql).setLong("shopId", shopId)
				.setDouble("sendPrice", sendPrice).executeUpdate();
	}

	@Override
	public List<ShopPo> getGoodsShops(Long categoryId, Integer indexPageNum, Integer size) {
		// TODO 未测试.
		String hql = "select s from ShopPo s,GoodsPo g where s.shopId = g.shopId and s.onSell=true and g.categoryId=:categoryId and g.nowNumber > 0 group by s.shopId ";
		@SuppressWarnings("unchecked")
		List<ShopPo> shopList = getCurrentSession()
				.createQuery(hql)
				.setLong("categoryId", categoryId)
				.setFirstResult((indexPageNum - 1) * size)
				.setMaxResults(size)
						.list();
		return shopList;
	}

	@Override
	public List<ShopPo> getPointTypeGoodsShops(Long categoryId,
			Integer shopType, PageInfo pageInfo) {
		// TODO 未测试.
		String hql = "select s from ShopPo s,GoodsPo g where s.onSell=true and s.shopType=:shopType and g.categoryId=:categoryId and g.nowNumber > 0 group by s.shopId";
		String hql2 = "select count(*) from ShopPo s,GoodsPo g where s.onSell=true and s.shopType=:shopType and g.categoryId =:categoryId and g.nowNumber>0 group by s.shopId";
		@SuppressWarnings("unchecked")
		List<ShopPo> shopList = getCurrentSession()
				.createQuery(hql)
				.setLong("categoryId", categoryId)
				.setInteger("shopType", shopType)
				.setFirstResult((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize())
						.list();
		Long uniqueResult = (Long) getCurrentSession().createQuery(hql2)
				.setLong("categoryId", categoryId)
				.setInteger("shopType", shopType).uniqueResult();
		pageInfo.setTotalCount(uniqueResult);
		return shopList;
	}

	@Override
	public Long addShop(ShopPo model) {
		Long save =  (Long) getCurrentSession().save(model);
		return save;
	}

	@Override
	public void updateShop(ShopPo shop) {
		getCurrentSession().update(shop);
	}

	@Override
	public List<ShopPo> getAllShop(PageInfo pageInfo) {
		// TODO 暂无完成.
		return null;
	}

	

}