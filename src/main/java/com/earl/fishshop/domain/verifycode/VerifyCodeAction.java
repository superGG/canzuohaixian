package com.earl.fishshop.domain.verifycode;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 验证码.
 * @author Administrator
 * 
 */
@Controller(value = "verifyCodeAction")
@Scope(value = "prototype")
public class VerifyCodeAction extends BaseAction<VerifyCodePo> {

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

	public void addVerifyCode() {
		Boolean save = verifyCodeServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 删除验证码.
	 * @author 宋文光.
	 */
	public void deleteUnit(){
		Boolean deleteById = verifyCodeServer.deleteById(model.getVerifycodeId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(deleteById);
	}
	
}
