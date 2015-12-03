package com.earl.fishshop.domain.goods;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.SingleFileVo;

public interface GoodsService extends BaseService<GoodsPo>{

	/**
	 * 修改商品价格.
	 * @author 黄祥谦.
	 * @param goodsList TODO
	 * @return
	 */
	Boolean updateGoodPrice(List<GoodsPo> goodsList);

	/**
	 * 修改商品数量.
	 * @author 黄祥谦.
	 * @param goodsList TODO
	 * @return
	 */
	Boolean updateGoodNowNumber(List<GoodsPo> goodsList);

	/**
	 * 通过商品类别得到指定商品.
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param pageInfo 
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Long categoryId, PageInfo pageInfo);

	/**
	 * 得到用户发布的该类别下的商品总量
	 * @author 黄祥谦.
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @param userId
	 * @return
	 */
	List<CategoryPo> getCategoryWithTotalNumber(Long shopId, Integer indexPageNum, Integer size);

	/**
	 * 得到商家发布的所有商品，数量为零的不显示
	 * @author 黄祥谦.
	 * @param shopId
	 * @param pageInfo 
	 * @return
	 */
	List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo);

	/**
	 * 得到商品详情.
	 * @author 黄祥谦.
	 * @param goodsId
	 * @return
	 */
	GoodsPo getGoodsInfo(Long goodsId);

	/**
	 * 删除指定商店的特定类别渔货
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param shopId
	 * @return
	 */
	Boolean deletePointCategoryGoods(Long categoryId, Long shopId);

	/**
	 * 添加商品.
	 * @author 黄祥谦.
	 * @param model
	 * @param categoryFile
	 * @return
	 */
	Boolean addGoods(CategoryPo model, SingleFileVo categoryFile);

	/**
	 * 商家得到指定类别的商品详情信息.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param categoryId
	 * @return
	 */
	List<SkuPo> getPointCategoryGoodsInfo(Long shopId, Long categoryId);

	List<GoodsPo> getShopPointCategory(Long shopId, Long categoryId, Integer indexPageNum, Integer size);

}
