package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.util.MyConstant;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "shopAction")
@Scope(value = "prototype")
public class ShopAction extends BaseAction<ShopPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	protected Long userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}


	// 下面填写业务逻辑

	public void addShop() {
		UserPo userPo = userServer.get(userId);
		resultMessage = new ResultMessage();
		if(userPo.getState() == MyConstant.user_pass){
			
			Boolean save = shopServer.save(model);
			resultMessage.setServiceResult(save);
		}else{
			resultMessage.setResultInfo("用户未认证");
			resultMessage.setServiceResult(false);
		}
	}
}
