package com.earl.fishshop.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.OrdersPo;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.vo.PageInfo;

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
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}


	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}


	// 下面填写业务逻辑

	public void addOrders() {
		Boolean save = ordersServer.addOrders(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 得到指定商店的所有订单.
	 * @author 黄祥谦.
	 */
	public void getMyShopOrders(){
		List<OrdersPo> ordersList = ordersServer.getMyShopOrders(model.getShopId(), pageInfo);
	}
	
	/**
	 * 得到未发货订单.
	 * @author 黄祥谦.
	 */
	public void getUnSentOrders(){
//		ordersServer.getUnSentOrders();
		
	}
	
	/**
	 * 未支付订单.
	 * @author 黄祥谦.
	 */
	public void getUnPayOrders(){
		
	}
	
	/**
	 * 得到待收货订单.
	 * @author 黄祥谦.
	 */
	public void getUngetOrders(){
		
	}
	
	/**
	 * 得到未评论订单.
	 * @author 黄祥谦.
	 */
	public void getUnCommentOrders(){
		
	}
	
	/**
	 * 得到本次出航的订单.
	 * @author 黄祥谦.
	 */
	public void getOrdersWithSeaRecord(){
		List<OrdersPo> orders = ordersServer.getOrdersWithSeaRecord(model.getSeaRecordId(), pageInfo);
	}
	
	/**
	 * 设置订单的订单编号.
	 * @author 黄祥谦.
	 */
	public void setOrderNumber(){
		
	}
}
