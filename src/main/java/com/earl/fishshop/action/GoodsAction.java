package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.vo.PageInfo;

/**
 * 
 * 商品Action.
 * 
 * @author Administrator.
 * 
 */
@Controller(value = "goodsAction")
@Scope(value = "prototype")
public class GoodsAction extends BaseAction<GoodsPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;
	
	private PageInfo pageInfo ;
	

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
	 * 添加商品.
	 * @author 黄祥谦.
	 */
	public void addGoods() {
		Boolean save = goodsServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
		
	}
	
	/**
	 * 更新商品价格.
	 * @author 黄祥谦.
	 */
	public void updateGoodPrice(){
		Boolean success = goodsServer.updateGoodPrice(model.getGoodsId(),model.getPrice());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
	}
	
	/**
	 * 更新商品数量.
	 * @author 黄祥谦.
	 */
	public void updateGoodNowNumber(){
		Boolean success = goodsServer.updateGoodNowNumber(model.getGoodsId(),model.getNowNumber());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
	}
	
	/**
	 * 得到指定商品类别的商品.
	 * @author 黄祥谦.
	 */
	public void getGoodsWithCategory(){
		List<GoodsPo> goodsList = goodsServer.getGoodsWithCategory(model.getCategoryId());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("goodsList", goodsList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 删除指定类别的渔获.
	 * @author 黄祥谦.
	 */
	public void deletePointCategoryGoods(){
		//TODO 将指定类别的商品删除，就是删除渔获.
		Boolean success = goodsServer.deletePointCategoryGoods(model.getCategoryId(),model.getShopId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
	}
	
	/**
	 * 得到商品信息
	 * @author 黄祥谦.
	 */
	public void getGoodsInfo(){
		GoodsPo goods= goodsServer.getGoodsInfo(model.getGoodsId());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("goodsList", goods);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
}
