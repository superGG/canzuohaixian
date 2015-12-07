package com.earl.fishshop.domain.shop;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;
import com.earl.fishshop.vo.PageInfo;

public interface ShopDao extends BaseDao<ShopPo>{

	/**
	 * 得到我的商店.
	 * @author 黄祥谦.
	 * @param userId TODO
	 * @return
	 */
	ShopPo getMyShop(Long userId);

	/**
	 * 更新起送价格.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param sendPrice TODO
	 */
	void updateSentPrice(Long shopId, Double sendPrice);

	/**
	 * 得到商店
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<ShopPo> getGoodsShops(Long categoryId, Integer indexPageNum, Integer size);

	/**
	 * 得到该类别下的养殖户商家的信息.
	 * @author 黄祥谦.
	 * @param categoryId
	 * @param shopType TODO
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getPointTypeGoodsShops(Long categoryId, Integer shopType, PageInfo pageInfo);

	/**
	 * 添加商店.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Long addShop(ShopPo model);

	void updateShop(ShopPo shop);
	
	/**
	 * 得到商店
	 * @author 宋文光.
	 * @param categoryId
	 * @param indexPageNum
	 * @param size TODO
	 * @return
	 */
	List<ShopPo> getGoodsShops(Long categoryId, Integer indexPageNum, Integer size,Integer sortType);

	/**
	 * 得到该类别下的养殖户商家的信息.
	 * @author 宋文光.
	 * @param categoryId
	 * @param shopType TODO
	 * @param pageInfo
	 * @return
	 */
	List<ShopPo> getPointTypeGoodsShops(Long categoryId, Integer shopType, PageInfo pageInfo,Integer sortType);
	

}
