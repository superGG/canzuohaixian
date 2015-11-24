package com.earl.fishshop.domain.orders;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.domain.getaddress.GetAddressPo;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;
import com.earl.fishshop.domain.postage.PostagePo;
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;


/**
 * 
 * 
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao {

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
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
		GetAddressPo object = (GetAddressPo) getCurrentSession().get(GetAddressPo.class, getAddressId);
		orders.setUserName(object.getUserName());
		orders.setSendAddress(object.getAddress());
		orders.setPhone(object.getPhone());
		getOrdersPostage(orders.getOrdersDetail(), object.getProvinceId());
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
					getCurrentSession().createQuery(hql).setLong("tosell", ordersDetailPo.getNumber()).setLong("categoryId",ordersDetailPo.getCategoryId()).executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				ordersDetailPo.setOrderId(ordersId);
				getCurrentSession().save(ordersDetailPo);
			}
		}
	}

	@Override
	public List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, PageInfo pageInfo) {
		
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("seaRecordId", seaRecordId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
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
	public List<OrdersPo> getPointStateOrders(Long userId, Integer state, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("state", state));
		createCriteria.add(Restrictions.eq("userId", userId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
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
	public List<OrdersPo> getAllUserOrders(Long userId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("userId", userId));
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
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

}