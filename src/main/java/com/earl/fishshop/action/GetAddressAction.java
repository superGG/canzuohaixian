package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GetAddressPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 收货地址.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "getAddressAction")
@Scope(value = "prototype")
public class GetAddressAction extends BaseAction<GetAddressPo> {

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
	 * 添加对象.
	 * @author 黄祥谦.
	 */
	public void addGetAddress() {
		Boolean save = getAddressServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
}
