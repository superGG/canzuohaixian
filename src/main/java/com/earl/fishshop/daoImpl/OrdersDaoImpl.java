package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersDetailPo;
import com.earl.fishshop.pojo.OrdersPo;


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
			String hql2 = "from OrdersDetailPo where orderId =: orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return list;
	}
	
	@Override
	public void updateOrdersState(Long ordersId, Integer state){
		String hql ="update OrdersPo set state =:state where ordersId =:ordersId";
		getCurrentSession().createQuery(hql).setInteger("state", state).setLong("ordersId", ordersId).executeUpdate();
	}

}