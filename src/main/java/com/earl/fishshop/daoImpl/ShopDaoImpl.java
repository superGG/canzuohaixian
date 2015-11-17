package com.earl.fishshop.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.ShopDao;
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
		
		String hql = "select ShopPo from ShopPo s,GoodsPo g where s.onSell=true and g.categoryId=:categoryId and g.nowNumber > 0 group by shopId limit :index to :afterIndex";
		String hql2 = "select count(*) from ShopPo s,GoodsPo g where s.onSell=true and g.categoryId:categoryId and g.nowNumber>0 group by shopId";
		List<ShopPo> shopList = getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).setInteger("index", ((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())).setInteger("afterIndex", ((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())+pageInfo.getSize()).list();
		Long uniqueResult = (Long) getCurrentSession().createQuery(hql2).setLong("categoryId", categoryId).uniqueResult();
		pageInfo.setTotalCount(uniqueResult);
		return shopList;
	}

	@Override
	public List<ShopPo> getPointTypeGoodsShops(Long categoryId, Integer shopType, PageInfo pageInfo) {
		// TODO 未测试.
		String hql = "select ShopPo from ShopPo s,GoodsPo g where s.onSell=true and s.shopType=:shopType and g.categoryId=:categoryId and g.nowNumber > 0 group by shopId limit :index to :afterIndex";
		String hql2 = "select count(*) from ShopPo s,GoodsPo g where s.onSell=true and s.shopType=:shopType and g.categoryId:categoryId and g.nowNumber>0 group by shopId";
		List<ShopPo> shopList = getCurrentSession().createQuery(hql).setLong("categoryId", categoryId).setInteger("shopType", shopType).setInteger("index", ((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())).setInteger("afterIndex", ((pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())+pageInfo.getSize()).list();
		Long uniqueResult = (Long) getCurrentSession().createQuery(hql2).setLong("categoryId", categoryId).setInteger("shopType", shopType).uniqueResult();
		pageInfo.setTotalCount(uniqueResult);
		return shopList;
	}

	@Override
	public Long addShop(ShopPo model) {
		// TODO 未测试.
		Long save = (Long) getCurrentSession().save(model);
		return save;
	}
}