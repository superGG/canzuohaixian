package com.earl.fishshop.action;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.FordersPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 购物车.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "fordersAction")
@Scope(value = "prototype")
public class FordersAction extends BaseAction<FordersPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑

	/**
	 * 添加购物车.
	 * @author 黄祥谦.
	 */
	public void addForderOrders() {
		Long forderId = fordersServer.addForders(model);
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("forderId",forderId);
		resultMessage.setResultParm(hashMap);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
	}
	
}
