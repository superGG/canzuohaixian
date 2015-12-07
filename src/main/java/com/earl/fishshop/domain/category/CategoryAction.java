package com.earl.fishshop.domain.category;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.ResultMessage;
import com.earl.fishshop.vo.SingleFileVo;

/**
 * 
 * 类别Action ,白星东斑鱼
 * 
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

	private SingleFileVo categoryFile;

	protected ResultMessage resultMessage;

	protected CategoryPo category;

	// 选择排序方式.
	private Integer sortType;

	@ReturnValue
	// 返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Integer getSortType() {
		return sortType;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}

	public SingleFileVo getCategoryFile() {
		return categoryFile;
	}

	public void setCategoryFile(SingleFileVo categoryFile) {
		this.categoryFile = categoryFile;
	}

	/**
	 * 添加商品类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void addCategory() {
		Boolean save = categoryServer.addCategory(model, categoryFile);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
		if (save) {
			resultMessage.setResultInfo("添加成功");
		} else {
			resultMessage.setResultInfo("添加失败");
		}
	}

	/**
	 * 添加商品.
	 * 
	 * @author 黄祥谦.
	 */
	public void addGoods() {
		Boolean save = goodsServer.addGoods(category, categoryFile);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
		if (save) {
			resultMessage.setResultInfo("添加成功");
		} else {
			resultMessage.setResultInfo("添加失败");
		}
	}

	/**
	 * 更新指定类别信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void updateCategory() {
		Boolean update = categoryServer.updateCategory(model, categoryFile);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}

	/**
	 * 删除指定类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void deleteCategory() {
		Boolean delete = categoryServer.deleteById(model.getCategoryId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(delete);
	}

	/**
	 * 得到带规格的类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void getCategoryWithSku(){
		CategoryPo category = categoryServer.getCategoryWithSku(model.getCategoryId());
		resultMessage = new ResultMessage();
		if (category != null) {
			resultMessage.setServiceResult(true);
		} else {
			resultMessage.setServiceResult(false);
		}
		resultMessage.getResultParm().put("category", category);
	}

	/**
	 * 得到顶层类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void getTopCategory() {
		List<CategoryPo> categoryList = categoryServer.getTopCategory();
		resultMessage = new ResultMessage();
		if (categoryList.size() != 0) {
			resultMessage.setServiceResult(true);
		} else {
			resultMessage.setServiceResult(false);
		}
		resultMessage.getResultParm().put("categoryList", categoryList);
	}

	public void getAllNextLevelCategory(){
		List<CategoryPo> categoryList = categoryServer.getAllNextLevelCategory();
		resultMessage = new ResultMessage();
		if (categoryList.size() != 0) {
			resultMessage.setServiceResult(true);
		} else {
			resultMessage.setServiceResult(false);
		}
		resultMessage.getResultParm().put("categoryList", categoryList);
	}

	/**
	 * 得到指定类别的下一级类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void getNextLevelCategory(){
		List<CategoryPo> categoryList = categoryServer.getNextLevelCategory(model.getCategoryId(), pageInfo);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo("方法执行成功");
		resultMessage.getResultParm().put("categoryList", categoryList);
	}

	/**
	 * --本月热门 URL： 参数：无 返回值： state message goodsArray:热门商品数组 good_id:商品唯一标识
	 * good_name:商品名称 good_name_english:商品英文名 good_sell_number:销量
	 * good_face_pic_url:商品图片url
	 * 
	 * 得到本月热门类别.
	 * 
	 * @author 黄祥谦.
	 */
	public void getHotCategory(){
		List<CategoryPo> categoryList = categoryServer.getHotCategory(application);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("categoryList", categoryList);
		resultMessage.setResultInfo("执行成功");
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定类别的商家信息.全部
	 * 
	 * @author 黄祥谦.
	 */
	public void getGoodsShops(){
		List<ShopPo> shopList = categoryServer.getGoodsShops(model.getCategoryId(), pageInfo.getIndexPageNum(), pageInfo.getSize());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定类别的渔户家信息.全部
	 * 
	 * @author 黄祥谦.
	 */
	public void getGoodsFishShops(){
		List<ShopPo> shopList = categoryServer.getGoodsFishShops(model.getCategoryId(), pageInfo);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到养殖户商家信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void getGoodsFarmerShops(){
		List<ShopPo> shopList = categoryServer.getGoodsFarmerShops(model.getCategoryId(), pageInfo);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定类别的商家信息.全部
	 * 
	 * @author 宋文光.
	 */
	public void getGoodsShops1() {
		List<ShopPo> shopList = categoryServer.getGoodsShops(
				model.getCategoryId(), pageInfo.getIndexPageNum(),
				pageInfo.getSize(), sortType);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定类别的渔户家信息.全部
	 * 
	 * @author 宋文光.
	 */
	public void getGoodsFishShops1() {
		List<ShopPo> shopList = categoryServer.getGoodsFishShops(
				model.getCategoryId(), pageInfo, sortType);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到指定类别的养殖户家信息.全部
	 * 
	 * @author 宋文光.
	 */
	public void getGoodsFarmerShops1() {
		List<ShopPo> shopList = categoryServer.getGoodsFarmerShops(
				model.getCategoryId(), pageInfo, sortType);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("shopList", shopList);
		resultMessage.setServiceResult(true);
	}

}
