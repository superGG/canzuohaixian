package com.earl.fishshop.domain.shop;

import java.util.List;
import java.util.Map;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.domain.comment.CommentPo;
import com.earl.fishshop.vo.PageInfo;

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

	/**
	 * 得到所有渔户的商店.
	 *@author 宋文光.
	 * @return
	 */
	List<Map<String, Object>> getAllFishmanShop();

	/**
	 * 获取所有养殖户的商店.
	 *@author 宋文光.
	 * @return
	 */
	List<Map<String, Object>> getAllFarmersShop();

	/**
	 * 客户端获取所有商店.
	 *@author 宋文光.
	 * @param pageInfo 分页信息.
	 * @return
	 */
	List<ShopPo> getAllShop(PageInfo pageInfo);

	/**
	 * 得到商店详细信息.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	ShopPo getShop(Long shopId);

	

}
