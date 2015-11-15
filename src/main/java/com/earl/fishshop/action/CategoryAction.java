package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.vo.PageInfo;

/**
 * 
 * 类别Action ,白星东斑鱼
 * @author 黄祥谦.
 * 
 */
@Controller(value = "categoryAction")
@Scope(value = "prototype")
public class CategoryAction extends BaseAction<CategoryPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	private PageInfo pageInfo;
	
	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	/**
	 * 添加商品类别.
	 * @author 黄祥谦.
	 */
	public void addCategory() {
		Boolean save = categoryServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 删除指定类别.
	 * @author 黄祥谦.
	 */
	public void deleteCategory(){
		Boolean delete = categoryServer.deleteById(model.getCategoryId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(delete);
	}
	
	/**
	 * 更新指定类别信息.
	 * @author 黄祥谦.
	 */
	public void updateCategory(){
		Boolean update = categoryServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 得到顶层类别.
	 * @author 黄祥谦.
	 */
	public void getTopCategory(){
		List<CategoryPo> categoryList = categoryServer.getTopCategory();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("categoryList", categoryList);
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * 得到指定类别的下一级类别.
	 * @author 黄祥谦.
	 */
	public void getNextLevelCategory(){
		List<CategoryPo> categoryList = categoryServer.getNextLevelCategory(model.getCategoryId(), pageInfo);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("categoryList", categoryList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * --本月热门
	 * URL：
	 * 参数：无
	 * 返回值：
	 * state
	 * message
	 * goodsArray:热门商品数组
	 *	good_id:商品唯一标识
	 *	good_name:商品名称
	 *	good_name_english:商品英文名
	 *	good_sell_number:销量
	 *	good_face_pic_url:商品图片url
	 * 
	 * 得到本月热门类别.
	 * @author 黄祥谦.
	 */
	public void getHotCategory(){
		List<CategoryPo> categoryList = categoryServer.getHotCategory(application);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("categoryList", categoryList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到指定类别的商家信息.
	 * @author 黄祥谦.
	 */
	public void getGoodsShops(){
		List<ShopPo> shopList = categoryServer.getGoodsShops(model.getCategoryId(), pageInfo);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("shopList", shopList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
}
