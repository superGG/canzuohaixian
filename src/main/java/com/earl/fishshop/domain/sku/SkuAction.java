package com.earl.fishshop.domain.sku;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 规格，只，斤
 * 
 * @author Administrator
 * 
 */
@Controller(value = "skuAction")
@Scope(value = "prototype")
public class SkuAction extends BaseAction<SkuPo> {

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

	public void addSku() {
		Boolean save = skuServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
}
