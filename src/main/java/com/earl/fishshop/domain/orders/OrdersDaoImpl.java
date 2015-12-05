package com.earl.fishshop.domain.orders;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;
import com.earl.fishshop.domain.postage.PostagePo;
import com.earl.fishshop.domain.sku.SkuPo;


/**
 * 
 * 
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao {

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId, Integer indexPageNum, Integer size) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId));
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList= createCriteria.list();
		
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
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
	public void addOrders(OrdersPo orders, Long getAddressId) {
		
		Long ordersId = (Long) getCurrentSession().save(orders);
		List<OrdersDetailPo> ordersDetail = orders.getOrdersDetail();
		if(ordersDetail != null){
			for (OrdersDetailPo ordersDetailPo : ordersDetail) {
				String hql = "update GoodsPo set nowNumber=nowNumber - :tosell,sellNumber=sellNumber + :tosell where goodsId =:goodsId and nowNumber-:tosell >= 0";
				Integer executeUpdate = getCurrentSession().createQuery(hql).setLong("tosell", ordersDetailPo.getNumber()).setLong("goodsId",ordersDetailPo.getGoodsId()).executeUpdate();
				if(executeUpdate == 0 ){
					throw new RuntimeException("商品数量不够！！");
				}
				String hql2 = "update CategoryPo set totalSellNumber = totalSellNumber+ :tosell where categoryId =:categoryId";
				try {
					getCurrentSession().createQuery(hql2).setLong("tosell", ordersDetailPo.getNumber()).setLong("categoryId",ordersDetailPo.getCategoryId()).executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ordersDetailPo.setOrderId(ordersId);
				getCurrentSession().save(ordersDetailPo);
			}
		}
	}

	@Override
	public List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, Integer indexPageNum, Integer size) {
		
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("seaRecordId", seaRecordId));
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

	@Override
	public void setOrderNumber(Long ordersId, String orderNumber) {
		String hql = "update OrdersPo set orderNumber =:orderNumber where ordersId =:ordersId";
		getCurrentSession().createQuery(hql).setString("orderNumber", orderNumber).setLong("ordersId", ordersId).executeUpdate();
	}

	@Override
	public List<OrdersPo> getAllUserOrders(Long userId, Integer indexPageNum, Integer size) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("userId", userId));
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).setFirstResult(0).setMaxResults(1).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

	@Override
	public Double getOrdersPostage(List<OrdersDetailPo> ordersDetail,
			Long provinceId) {
		// TODO 未测试.
		Double postagePrice = 0.0;
		Double weight = 0.0;
		for (OrdersDetailPo ordersDetailPo : ordersDetail) {
			String unit = ordersDetailPo.getUnit();
			if( "斤".equals(unit)){
				weight = weight + ordersDetailPo.getNumber();
			}else{
				SkuPo sku = (SkuPo) getCurrentSession().get(SkuPo.class, ordersDetailPo.getSkuId());
				weight = weight + ((sku.getLowscale()+sku.getHighscale())/2) * ordersDetailPo.getNumber();
			}
		}
		PostagePo postage = (PostagePo) getCurrentSession().get(PostagePo.class, provinceId);
		if( weight<=1){
			postagePrice = postage.getFirstWeigh();
		}else{
			postagePrice = postage.getFirstWeigh()+postage.getIncreasePrice()*(weight -1);
		}
		return postagePrice;
	}

	@Override
	public void updateOrder(OrdersPo order) {
		getCurrentSession().update(order);
		
	}

	@Override
	public List<OrdersPo> getAllOrders(Integer indexPageNum, Integer size) {
		// TODO 未测试.
		String hql = "from OrdersPo";
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = getCurrentSession().createQuery(hql).setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size).list();
		return ordersList;
	}

	@Override
	public OrdersPo getPointOrders(Long ordersId) {
		// TODO 未测试.
		OrdersPo ordersPo = get(ordersId);
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		return ordersPo;
	}

	@Override
	public List<OrdersPo> getPointStateOrders(Long userId, Integer state, Integer indexPageNum, Integer size) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("state", state));
		createCriteria.add(Restrictions.eq("userId", userId));
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

	@Override
	public List<OrdersPo> getShopPointStateOrders(Long shopId, Integer state,
			Integer indexPageNum, Integer size) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("state", state));
		createCriteria.add(Restrictions.eq("shopId", shopId));
		createCriteria.setFirstResult(
				(indexPageNum - 1) * size)
				.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<OrdersPo> ordersList = createCriteria.list();
		for (OrdersPo ordersPo : ordersList) {
			String hql2 = "from OrdersDetailPo where orderId =:orderId";
			@SuppressWarnings("unchecked")
			List<OrdersDetailPo> ordersDetailList = getCurrentSession().createQuery(hql2).setLong("orderId", ordersPo.getOrdersId()).list();
			ordersPo.setOrdersDetail(ordersDetailList);
		}
		return ordersList;
	}

}