package com.earl.fishshop.domain.orders;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.ResultMessage;
import com.pingplusplus.model.Charge;

/**
 * 订单
 * @author Administrator
 */
@Controller(value = "ordersAction")
@Scope(value = "prototype")
public class OrdersAction extends BaseAction<OrdersPo> {

	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;
	
	private PageInfo pageInfo;
	
	OrdersPo orders;
	
	Long payOrdersId;
	
	String channel;
	
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

	public Long getPayOrdersId() {
		return payOrdersId;
	}

	public void setPayOrdersId(Long payOrdersId) {
		this.payOrdersId = payOrdersId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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
		if(save){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
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
		List<OrdersPo> ordersList = ordersServer.getMyShopOrders(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("ordersList", ordersList);
	}
	
	/**
	 * 得到本次出航的订单.
	 * @author 黄祥谦.
	 */
	public void getOrdersWithSeaRecord(){
		List<OrdersPo> ordersList = ordersServer.getOrdersWithSeaRecord(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 支付订单费用.
	 * @author 黄祥谦.
	 */
	public void payForOrdersWithAlipay(){
		Charge charge = ordersServer.payForOrders(model.getOrdersId(), channel);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("charge", charge);
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
	 * 得到订单快递编号.
	 * @author 黄祥谦.
	 */
	public void getOrderNumber(){
		OrdersPo ordersPo = ordersServer.get(model.getOrdersId());
		resultMessage = new ResultMessage();
		if(ordersPo != null){
			resultMessage.getResultParm().put("ordersNumber", ordersPo.getOrderNumber());
			resultMessage.setResultInfo("执行成功");
			resultMessage.setServiceResult(true);
		}else{
			resultMessage.setResultInfo("执行失败");
			resultMessage.setServiceResult(false);
		}
	}
	
	/**
	 * 得到订单运费.
	 * @author 黄祥谦.
	 */
	public void getOrdersPostage(){
		Double postagePrice = ordersServer.getOrdersPostage(model, getAddressId);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("postagePrice", postagePrice);
		if(postagePrice != null){
			resultMessage.setServiceResult(true);
			resultMessage.setResultInfo("请求成功");
		}else{
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("请求失败");
		}
	}
	
	/**
	 * 得到指定订单信息.
	 * @author 黄祥谦.
	 */
	public void getPointOrders(){
		OrdersPo orders = ordersServer.getPointOrders(model.getOrdersId());
		
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("orders", orders);
		if(orders != null){
			resultMessage.setServiceResult(true);
			resultMessage.setResultInfo("请求成功");
		}else{
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("请求失败");
		}
	}
	
	/**
	 * 获得所有订单，不带订单项.
	 * @author 黄祥谦.
	 */
	public void getAllOrders(){
		List<OrdersPo> ordersList = ordersServer.getAllOrders(pageInfo.getIndexPageNum(), pageInfo.getSize());
		
		resultMessage = new ResultMessage();
		if(ordersList != null){
			resultMessage.setServiceResult(true);
			resultMessage.setResultInfo("请求成功");
		}else{
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("请求失败");
		}
		resultMessage.getResultParm().put("orders", orders);
	}

	/**
	 * 真实支付订单，修改订单状态为未发货.
	 * @author 黄祥谦.
	 */
	public void realPayOrders(){
		Boolean success = ordersServer.realPayOrders(model.getOrdersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		
	}

	/**
	 * 修改订单状态为未收货,已发货.
	 * @author 黄祥谦.
	 */
	public void realSendOrders(){
		Boolean success = ordersServer.realSendOrders(model.getOrdersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
	}

	/**
	 * 修改订单状态为未评论,已收货.
	 * @author 黄祥谦.
	 */
	public void realGetOrders(){
		Boolean success = ordersServer.realGetOrders(model.getOrdersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
	}

	/**
	 * 用户得到用户所有订单.只显示一条东西.
	 * @author 黄祥谦.
	 */
	public void getAllUserOrders(){
		List<OrdersPo> ordersList = ordersServer.getAllUserOrders(model.getUserId(),pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("ordersList", ordersList);
	}

	/**
	 * 客户得到未发货订单.
	 * @author 黄祥谦.
	 */
	public void getUnSentOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnSentOrders(model.getUserId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 商家得到未发货订单.
	 * @author 黄祥谦.
	 */
	public void getShopUnSentOrders(){
		List<OrdersPo> ordersList = ordersServer.getShopUnSentOrders(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 用户未支付订单.
	 * @author 黄祥谦.
	 */
	public void getUnPayOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnpayOrders(model.getUserId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 商家得到未支付订单.
	 * @author 黄祥谦.
	 */
	public void getShopUnPayOrders(){
		List<OrdersPo> ordersList = ordersServer.getShopUnPayOrders(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("ordersList", ordersList);
	}
	
	/**
	 * 用户得到待收货订单.
	 * @author 黄祥谦.
	 */
	public void getUngetOrders(){
		List<OrdersPo> ordersList = ordersServer.getUngetOrders(model.getUserId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("ordersList", ordersList);
	}

	
	/**
	 * 商家得到未收货订单.
	 * @author 黄祥谦.
	 */
	public void getShopUngetOrders(){
		List<OrdersPo> ordersList = ordersServer.getShopUnGetOrders(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到未评论订单.
	 * @author 黄祥谦.
	 */
	public void getUnCommentOrders(){
		List<OrdersPo> ordersList = ordersServer.getUnCommentOrders(model.getUserId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("ordersList", ordersList);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 商家得到未收货订单.
	 * @author 黄祥谦.
	 */
	public void getShopUnCommentOrders(){
		List<OrdersPo> ordersList = ordersServer.getShopUnCommentOrders(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("ordersList", ordersList);
	}
	
}
