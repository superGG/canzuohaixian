package com.earl.fishshop.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.vo.PageInfo;

/**
 * 
 * 商店信息
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

	/**
	 * 添加商店信息.
	 * @author 黄祥谦.
	 */
	public void addShop() {
			
			Boolean save = shopServer.addShop(model);
			resultMessage.setServiceResult(save);
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
	
	/**
	 * 得到商家发布的所有商品，数量为0的不显示.
	 * @author 黄祥谦.
	 */
	public void getShopAllGoods(){
		List<GoodsPo> goodsList = goodsServer.getShopAllGoods(model.getShopId(), pageInfo);
	}
	
	/**
	 * 得到指定商店信息.
	 * @author 黄祥谦.
	 */
	public void getShop(){
	ShopPo shop = shopServer.get(model.getShopId());
	System.out.println(shop);
	}
	
	/**
	 * 到港口了，停止出港
	 * @author 黄祥谦.
	 */
	public void endSeaing(){
	Boolean success = shopServer.endSeaing(model.getShopId());
	
	}
}
