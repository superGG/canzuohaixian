package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GetTypePo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 捕捞类型Action.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "getTypeAction")
@Scope(value = "prototype")
public class GetTypeAction extends BaseAction<GetTypePo> {

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

	public void addGetType() {
		Boolean save = getTypeServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
}
