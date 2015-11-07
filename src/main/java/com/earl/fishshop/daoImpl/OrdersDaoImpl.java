package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.pojo.SordersPo;


/**
 * 
 * 
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao {

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId) {
		// TODO 未测试.
		String hql ="from OrdersPo where shopId =:shopId";
		@SuppressWarnings("unchecked")
		List<OrdersPo> list = getCurrentSession().createQuery(hql).setLong("shopId", shopId).list();
		for (OrdersPo ordersPo : list) {
			String hql2 = "from SordersPo where orderId =: orderId";
			@SuppressWarnings("unchecked")
			List<SordersPo> sordersList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setSorders(sordersList);
		}
		return list;
	}

}