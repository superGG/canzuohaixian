package com.earl.fishshop.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CategoryPo;
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

	/**
	 * 添加商店信息.
	 * @author 黄祥谦.
	 */
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
	
	/**
	 * 更新商店信息.
	 * @author 黄祥谦.
	 */
	public void updateShop(){
		Boolean update = shopServer.update(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 更新起送价格
	 * @author 黄祥谦.
	 */
	public void updateSentPrice(){
		Boolean update = shopServer.updateSentPrice(model.getShopId(), model.getSendPrice());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 已上架渔获.
	 * 得到类别信息，附带用户的该类别的总货存量.
	 * @author 黄祥谦.
	 */
	public void getCategoryWithTotalNumber(){
		List<CategoryPo> categoryList = goodsServer.getCategoryWithTotalNumber(model.getShopId());
	}
}
