package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.OrdersPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
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

	protected OrdersPo jsonInputStream;
	protected OrdersPo model;

	@ReturnValue //返回实体对象，或者其他任意对象
	public OrdersPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		ordersServer.save(model);
		OrdersPo ordersPo = new OrdersPo();
		jsonInputStream = ordersPo;
		
	}
}
