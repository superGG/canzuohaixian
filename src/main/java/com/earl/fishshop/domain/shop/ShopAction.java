package com.earl.fishshop.domain.shop;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.domain.goods.GoodsPo;
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.ResultMessage;

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

	private ResultMessage resultMessage;

	private PageInfo pageInfo;

	private Long categoryId;
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}

	@ReturnValue
	// 返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑

	/**
	 * 添加商店信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void addShop() {

		Boolean save = shopServer.addShop(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}

	/**
	 * 更新商店信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void updateShop() {
		Boolean update = shopServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}

	/**
	 * 更新起送价格
	 * 
	 * @author 黄祥谦.
	 */
	public void updateSentPrice() {
		Boolean update = shopServer.updateSentPrice(model.getShopId(),
				model.getSendPrice());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}

	/**
	 * 已上架渔获. 得到类别信息，附带用户的该类别的总货存量.
	 * 
	 * @author 黄祥谦.
	 */
	public void getCategoryWithTotalNumber() {
		List<CategoryPo> categoryList = goodsServer
				.getCategoryWithTotalNumber(model.getShopId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		if(categoryList.size()!=0){
			resultMessage.setServiceResult(true);
		}else{
			resultMessage.setServiceResult(false);
		}
		resultMessage.getResultParm().put("categoryList", categoryList);
	}
	/**
	* 获得指定类别的渔获，包括规格信息，价格信息.
	* @author 黄祥谦.
	*/
	public void getPointCategoryGoodsInfo() {
		List<SkuPo> skuList = goodsServer
				.getPointCategoryGoodsInfo(model.getShopId(),categoryId);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("skuList", skuList);
	}

	/**
	 * 得到商家发布的所有商品，数量为0的不显示.
	 * 
	 * @author 黄祥谦.
	 */
	public void getShopAllGoods() {
		List<GoodsPo> goodsList = goodsServer.getShopAllGoods(
				model.getShopId(), pageInfo);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("goodsList", goodsList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定商店信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void getShop() {
		ShopPo shop = shopServer.getShop(model.getShopId());
		System.out.println(shop);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shop", shop);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 获取商店的评论信息.
	 * 
	 * @author 宋文光.
	 */
	public void getShopCommentInfo() {
		Map<String, Object> hashMap = shopServer.getShopCommentInfo(model
				.getShopId());
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 获取所有渔户商店(后台).
	 *@author 宋文光.
	 */
	public void getAllFishmanShop() {
		List<Map<String, Object>> list = shopServer.getAllFishmanShop();
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("shopInfo", list);
		resultMessage.getResultParm().put("number", list.size());
	}
	
	/**
	 * 获取所有养殖户商店(后台).
	 *@author 宋文光.
	 */
	public void getAllFarmersShop() {
		List<Map<String, Object>> list = shopServer.getAllFarmersShop();
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("shopInfo", list);
		resultMessage.getResultParm().put("number", list.size());
	}

}
