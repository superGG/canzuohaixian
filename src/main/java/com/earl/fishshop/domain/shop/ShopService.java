package com.earl.fishshop.domain.shop;

import java.util.Map;

import com.earl.fishshop.base.BaseService;
import com.earl.fishshop.pojo.CommentPo;
import com.earl.fishshop.pojo.ShopPo;

public interface ShopService extends BaseService<ShopPo>{

	/**
	 * 得到我的商店.
	 * @author 黄祥谦.
	 * @param userId 用户id
	 * @return
	 */
	ShopPo getMyShop(Long userId);

	/**
	 * 更新起送价格.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param sendPrice TODO
	 * @return
	 */
	Boolean updateSentPrice(Long shopId, Double sendPrice);

	/**
	 * 添加商店信息.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addShop(ShopPo model);

	/**
	 * 停止航行.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	Boolean endSeaing(Long shopId);

	/**
	 * 更新商店的评分.
	 *@author 宋文光.
	 * @param model
	 */
	void updateShopComment(CommentPo model);

	/**
	 * 获取商店的评论信息.
	 *@author 宋文光.
	 * @param shopId
	 * @return
	 */
	Map<String, Object> getShopCommentInfo(Long shopId);

	

}
