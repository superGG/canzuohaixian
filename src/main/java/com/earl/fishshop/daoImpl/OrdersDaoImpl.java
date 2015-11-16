package com.earl.fishshop.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersDetailPo;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.PageInfo;


/**
 * 
 * 
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao {

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId, PageInfo pageInfo) {
		// TODO 未测试.
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList= createCriteria.list();
		
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =: orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}
	
	@Override
	public void updateOrdersState(Long ordersId, Integer state){
		String hql ="update OrdersPo set state =:state where ordersId =:ordersId";
		getCurrentSession().createQuery(hql).setInteger("state", state).setLong("ordersId", ordersId).executeUpdate();
	}

	@Override
	public void addOrders(OrdersPo orders) {
		// TODO 未测试.
		orders.setState(MyConstant.order_unpay);//设置订单初始状态.
		Long ordersId = (Long) getCurrentSession().save(orders);
		List<OrdersDetailPo> ordersDetail = orders.getOrdersDetail();
		if(ordersDetail != null){
			for (OrdersDetailPo ordersDetailPo : ordersDetail) {
				String hql = "update GoodsPo set nowNumber=nowNumber - :tosell,sellNumber=sellNumber + :tosell where goodsId =:goodsId and nowNubmer-:tosell >= 0";
				Integer executeUpdate = getCurrentSession().createQuery(hql).setLong("tosell", ordersDetailPo.getNumber()).setLong("goodsId",ordersDetailPo.getGoodsId()).executeUpdate();
				if(executeUpdate == 0 ){
					throw new RuntimeException("商品数量不够！！");
				}
				ordersDetailPo.setOrderId(ordersId);
				getCurrentSession().save(ordersDetailPo);
			}
		}
	}

	@Override
	public List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo) {
		// TODO 未测试.
		
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("seaRecordId", seaRecordId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =: orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

	@Override
	public List<OrdersPo> getPointStateOrders(Integer state, PageInfo pageInfo) {
		// TODO 未测试.
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("state", state));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =: orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

	@Override
	public void setOrderNumber(Long ordersId, String orderNumber) {
		// TODO 未测试.
		String hql = "update OrdersPo set orderNumber =:orderNumber where ordersId =:ordersId";
		getCurrentSession().createQuery(hql).setString("orderNumber", orderNumber).setLong("ordersId", ordersId).executeUpdate();
	}

}