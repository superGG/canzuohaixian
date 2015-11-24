package com.earl.fishshop.domain.orders;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.ResultMessage;
import com.pingplusplus.model.Charge;

/**
 * 
 * 订单
 * 
 * @author Administrator
 * 
 */
@Controller(value = "ordersAction")
@Scope(value = "prototype")
public class OrdersAction extends BaseAction<OrdersPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;
	
	private PageInfo pageInfo;
	
	OrdersPo orders;
	
	private Long getAddressId;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Long getGetAddressId() {
		return getAddressId;
	}


	public void setGetAddressId(Long getAddressId) {
		this.getAddressId = getAddressId;
	}


	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑

	public void addOrders() {
		Boolean save = ordersServer.addOrders(orders, getAddressId);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 更新订单.包括状态
	 * @author 黄祥谦.
	 */
	public void updateOrders(){
		Boolean updateWithNotNullProperties = ordersServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(updateWithNotNullProperties);
		
	}
	
	/**
	 * 取消订单.
	 * @author 黄祥谦.
	 */
	public void deleteOrders(){
		Boolean deleteById = ordersServer.deleteById(model.getOrdersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(deleteById);
	}
	
	/**
	 * 得到指定商店的所有订单.
	 * @author 黄祥谦.
	 */
	public void getMyShopOrders(){
		List<OrdersPo> ordersList = ordersServer.getMyShopOrders(model.getShopId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到用户所有订单.
	 * @author 黄祥谦.
	 */
	public void getAllUserOrders(){
		List<OrdersPo> ordersList = ordersServer.getAllUserOrders(model.getUserId(),pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 客户得到未发货订单.
	 * @author 黄祥谦.
	 */
	public void getUnSentOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnSentOrders(model.getUserId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 未支付订单.
	 * @author 黄祥谦.
	 */
	public void getUnPayOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnpayOrders(model.getUserId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到待收货订单.
	 * @author 黄祥谦.
	 */
	public void getUngetOrders(){
		List<OrdersPo> ordersList = ordersServer.getUngetOrders(model.getUserId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到未评论订单.
	 * @author 黄祥谦.
	 */
	public void getUnCommentOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnCommentOrders(model.getUserId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到本次出航的订单.
	 * @author 黄祥谦.
	 */
	public void getOrdersWithSeaRecord(){
		List<OrdersPo> ordersList = ordersServer.getOrdersWithSeaRecord(model.getSeaRecordId(), pageInfo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("ordersList", ordersList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 支付订单费用.
	 * @author 黄祥谦.
	 */
	public void payForOrdersWithAlipay(){
		Charge charge = ordersServer.payForOrdersWithAlipay(model.getOrdersId());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("charge", charge);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * 真实支付订单，修改订单状态.
	 * @author 黄祥谦.
	 */
	public void realPayOrders(){
		Boolean success = ordersServer.realPayOrders(model.getOrdersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		
	}
	
	/**
	 * 设置订单的订单编号.
	 * @author 黄祥谦.
	 */
	public void setOrderNumber(){
		Boolean success = ordersServer.setOrderNumber(model.getOrdersId(), model.getOrderNumber());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
	}
	
	/**
	 * 得到订单运费.
	 * @author 黄祥谦.
	 */
	public void getOrdersPostage(){
		Double postagePrice = ordersServer.getOrdersPostage(model);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("postagePrice", postagePrice);
		resultMessage = new ResultMessage();
		if(postagePrice != null){
			
			resultMessage.setServiceResult(true);
		}else{
			resultMessage.setServiceResult(false);
		}
	}
	
	
}
