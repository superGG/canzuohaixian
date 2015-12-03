package com.earl.fishshop.domain.goods;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;

public interface GoodsDao extends BaseDao<GoodsPo>{

	/**
	 * 修改商品价格.
	 * @author 黄祥谦.
	 * @param goodsList TODO
	 */
	void updateGoodPrice(List<GoodsPo> goodsList);

	/**
	 * 更新商品数量.
	 * @author 黄祥谦.
	 * @param goodsList TODO
	 */
	void updateGoodNowNumber(List<GoodsPo> goodsList);

	/**
	 * 得到商家指定类别的商品.
	 * @author 黄祥谦.
	 * @param goodsCategory
	 * @param pageInfo 
	 * @return
	 */
	List<GoodsPo> getGoodsWithCategory(Long goodsCategory, PageInfo pageInfo);

	/**
	 * 已上架渔获.
	 * 得到类别分类，group by category.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param indexPageNum TODO
	 * @param size TODO
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
	 * 删除指定商店的特定类别渔货
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param shopId
	 * @return
	 */
	void deletePointCategoryGoods(Long categoryId, Long shopId);

	/**
	 * 批量添加，集成事务
	 * @author 黄祥谦.
	 * @param arrayList
	 */
	void saveList(List<GoodsPo> arrayList);

	/**
	 * 商家得到指定类别的商品详情.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param categoryId
	 * @return
	 */
	List<SkuPo> getPointCategoryGoodsInfo(Long shopId, Long categoryId);

	/**
	 * 得到商家的指定类别的商品.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param categoryId
	 * @param indexPageNum TODO
	 * @param size TODO
	 * @return
	 */
	List<GoodsPo> getShopPointCategory(Long shopId, Long categoryId, Integer indexPageNum, Integer size);

}
