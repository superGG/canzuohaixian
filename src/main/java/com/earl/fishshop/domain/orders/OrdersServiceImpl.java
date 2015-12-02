package com.earl.fishshop.domain.orders;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.getaddress.GetAddressPo;
import com.earl.fishshop.domain.goods.GoodsPo;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;
import com.earl.fishshop.domain.postage.PostagePo;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.util.MyConstant;
import com.earl.util.PayChargeUtil;
import com.pingplusplus.model.Charge;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "ordersService")
public class OrdersServiceImpl extends BaseServiceImpl<OrdersPo> implements
		OrdersService {

	@Resource(name = "ordersDao")
	OrdersDao ordersDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = ordersDao;
	}

	@Override
	public List<OrdersPo> getMyShopOrders(Long shopId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getMyShopOrders(shopId, indexPageNum, size);
		return ordersList;
	}

	@Override
	public Boolean addOrders(OrdersPo orders, Long getAddressId) {
		try {
			Double totalOrdersPrice = 0.0;
			orders.setState(MyConstant.order_unpay);//设置订单初始状态.
			orders.setSordersNumber(orders.getOrdersDetail().size());
			for (OrdersDetailPo ordersDetail : orders.getOrdersDetail()) {
				GoodsPo goodsPo = goodsDao.get(ordersDetail.getGoodsId());
				ordersDetail.setShopId(goodsPo.getShopId());
				ordersDetail.setCategoryId(goodsPo.getCategoryId());
				ordersDetail.setGoodsName(goodsPo.getGoodsName());
				ordersDetail.setPrice(goodsPo.getPrice());
				ordersDetail.setSkuId(goodsPo.getSku());
				ordersDetail.setSku(skuDao.get(goodsPo.getSku()).getSkuName());
				ordersDetail.setUnit(goodsPo.getUnit());
				ordersDetail.setGoodsPhoto(goodsPo.getGoodsPhoto());
				Double singalPrice = ordersDetail.getNumber()*ordersDetail.getPrice();
				ordersDetail.setTotalprice(singalPrice);
				totalOrdersPrice = totalOrdersPrice+singalPrice;
			}
			GetAddressPo getAddressPo = getAddressDao.get(getAddressId);
			orders.setUserName(getAddressPo.getUserName());
			orders.setSendAddress(getAddressPo.getAddress());
			orders.setPhone(getAddressPo.getPhone());
			
			String address = getAddressPo.getAddress();
			String substring = address.substring(0,address.indexOf("省")+1);
			PostagePo postagePo = new PostagePo();
			postagePo.setProvinceName(substring);
			List<PostagePo> findLikeGivenCreteriaWithPage = postageDao.findLikeGivenCreteriaWithPage(postagePo,null);
			orders.setProvinceId(findLikeGivenCreteriaWithPage.get(0).getPostageId());
			Double ordersPostage = getOrdersPostage(orders);
			orders.setPostagePrice(ordersPostage);
			orders.setSordersNumber(orders.getOrdersDetail().size());
			orders.setTotalprice(totalOrdersPrice+ordersPostage);
			ordersDao.addOrders(orders, getAddressId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}

	@Override
	public List<OrdersPo> getOrdersWithSeaRecord(Long seaRecordId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getOrdersWithSeaRecord(seaRecordId, indexPageNum, size);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUnSentOrders(Long userId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(userId, MyConstant.order_unsent, indexPageNum, size);
		return ordersList;
	}
	
	@Override
	public List<OrdersPo> getUnpayOrders(Long userId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(userId, MyConstant.order_unpay, indexPageNum, size);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUngetOrders(Long userId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(userId, MyConstant.order_unget, indexPageNum, size);
		return ordersList;
	}

	@Override
	public List<OrdersPo> getUnCommentOrders(Long userId, Integer indexPageNum, Integer size) {
		List<OrdersPo> ordersList = ordersDao.getPointStateOrders(userId, MyConstant.order_uncomment, indexPageNum, size);
		return ordersList;
	}

	@Override
	public Boolean setOrderNumber(Long orderId, String orderNumber) {
		try {
			ordersDao.setOrderNumber(orderId, orderNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//                                           alipay:支付宝手机支付
	//                                           alipay_wap:支付宝手机网页支付
	//                                           alipay_qr:支付宝扫码支付
	//                                           alipay_pc_direct:支付宝 PC 网页支付
	//                                           apple_pay:Apple Pay
	//                                           bfb:百度钱包移动快捷支付
	//                                           bfb_wap:百度钱包手机网页支付
	//                                           upacp:银联全渠道支付（2015 年 1 月 1 日后的银联新商户使用。若有疑问，请与 Ping++ 或者相关的收单行联系）
	//                                           upacp_wap:银联全渠道手机网页支付（2015 年 1 月 1 日后的银联新商户使用。若有疑问，请与 Ping++ 或者相关的收单行联系）
	//                                           upacp_pc:银联 PC 网页支付
	//                                           upmp:银联手机支付（限个人工作室和 2014 年之前的银联老客户使用。若有疑问，请与 Ping++ 或者相关的收单行联系）
	//                                           upmp_wap:银联手机网页支付（限个人工作室和 2014 年之前的银联老客户使用。若有疑问，请与 Ping++ 或者相关的收单行联系）
	//                                           wx:微信支付
	//                                           wx_pub:微信公众账号支付
	//                                           wx_pub_qr:微信公众账号扫码支付
	//                                           yeepay_wap:易宝手机网页支付
	//                                           jdpay_wap:京东手机网页支付
	//                                           cnp_u:应用内快捷支付（银联）
	//                                           cnp_f:应用内快捷支付（外卡）
	@Override
	public Charge payForOrdersWithAlipay(Long ordersId) {
		// TODO 未测试.
		OrdersPo ordersPo = ordersDao.get(ordersId);
		Double price = ordersPo.getTotalprice()*100;
		Charge charge = PayChargeUtil.charge(ordersPo.getOrdersId(), price.longValue(), "alipay", ordersPo.getShopKeeperName(), ordersPo.getBuyerName());
		return charge;
	}

	@Override
	public List<OrdersPo> getAllUserOrders(Long userId, Integer indexPageNum, Integer size) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getAllUserOrders(userId, indexPageNum, size);
		return ordersList;
	}

	@Override
	public Double getOrdersPostage(OrdersPo model) {
		// TODO 未测试.
		List<OrdersDetailPo> ordersDetail = model.getOrdersDetail();
		for (OrdersDetailPo ordersDetailPo : ordersDetail) {
			ordersDetailPo.getSkuId();
		}
		Double postagePrice = ordersDao.getOrdersPostage(model.getOrdersDetail(),model.getProvinceId());
		return postagePrice;
	}

	@Override
	public OrdersPo getPointOrders(Long ordersId) {
		// TODO 未测试.
		OrdersPo orders = ordersDao.getPointOrders(ordersId);
		orders.setSordersNumber(orders.getOrdersDetail().size());
		ShopPo shopPo = shopDao.get(orders.getShopId());
		orders.setShopPhoto(shopPo.getShopPhoto());
		return orders;
	}

	@Override
	public List<OrdersPo> getAllOrders(Integer indexPageNum, Integer size) {
		// TODO 未测试.
		List<OrdersPo> ordersList = ordersDao.getAllOrders(indexPageNum, size);
		return ordersList;
	}

	@Override
	public Boolean realPayOrders(Long ordersId) {
		// TODO 未测试.
		try {
			OrdersPo ordersPo = ordersDao.get(ordersId);
			if(ordersPo.getState() == MyConstant.order_unpay){
				ordersDao.updateOrdersState(ordersId, MyConstant.order_unsent);
			}else{
				throw new RuntimeException("非法操作!");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean realSendOrders(Long ordersId) {
		// TODO 未测试.
		try {
			OrdersPo ordersPo = ordersDao.get(ordersId);
			if(ordersPo.getState() == MyConstant.order_unsent){
				ordersDao.updateOrdersState(ordersId, MyConstant.order_unget);
			}else{
				throw new RuntimeException("非法操作!");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean realGetOrders(Long ordersId) {
		// TODO 未测试.
		try {
			OrdersPo ordersPo = ordersDao.get(ordersId);
			if(ordersPo.getState() == MyConstant.order_unget){
				ordersDao.updateOrdersState(ordersId, MyConstant.order_uncomment);
			}else{
				throw new RuntimeException("非法操作!");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
