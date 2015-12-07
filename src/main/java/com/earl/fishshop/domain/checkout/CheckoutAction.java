package com.earl.fishshop.domain.checkout;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 审查认证Action.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "checkoutAction")
@Scope(value = "prototype")
public class CheckoutAction extends BaseAction<CheckoutPo> {

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
	public void addCheckout() {
		Boolean save = checkoutServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 审查通过.
	 * @author 黄祥谦.
	 */
	public void passRecord(){
		Boolean result = checkoutServer.passRecord(model.getCheckoutId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 审查失败.
	 * @author 黄祥谦.
	 */
	public void nopassRecord(){
		Boolean result = checkoutServer.nopassRecord(model.getCheckoutId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	public void xxx(){
//		ApplicationContext
	}
}
