package com.earl.fishshop.domain.comment;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.vo.PageInfo;

public interface CommentDao extends BaseDao<CommentPo>{

	/**
	 * 获取某商店的虽有评论.
	 *@author 宋文光.
	 * @param shopId 商店id.
	 * @return
	 */
	List<CommentPo> getShopComment(Long shopId);

	/**
	 * 获取某商店的好评.
	 * @author 宋文光.
	 * @param shopId 商店id.
	 * @return
	 */
	List<CommentPo> getGoodComment(Long shopId);
	
	/**
	 * 获取某商店的中评.
	 *@author 宋文光.
	 * @param shopId 商店id.
	 * @return
	 */
	List<CommentPo> getMidComment(Long shopId);
	
	/**
	 * 获取某商店的差评.
	 *@author 宋文光.
	 * @param shopId 商店id.
	 * @return
	 */
	List<CommentPo> getBedComment(Long shopId);

	/**
	 * 获取商店所有评论.
	 *@author 宋文光.
	 * @param shopId
	 * @param pageInfo
	 * @return
	 */
	List<CommentPo> getShopComment(Long shopId, PageInfo pageInfo);

	/**
	 * 中评.
	 *@author 宋文光.
	 * @param shopId
	 * @param pageInfo
	 * @return
	 */
	List<CommentPo> getMidComment(Long shopId, PageInfo pageInfo);

	/**
	 * 好评.
	 *@author 宋文光.
	 * @param shopId
	 * @param pageInfo
	 * @return
	 */
	List<CommentPo> getGoodComment(Long shopId, PageInfo pageInfo);

	/**
	 * 差评.
	 *@author 宋文光.
	 * @param shopId
	 * @param pageInfo
	 * @return
	 */
	List<CommentPo> getBedComment(Long shopId, PageInfo pageInfo);

	/**
	 * 用户自己的评论.
	 *@author 宋文光.
	 * @param creatorId
	 * @param pageInfo
	 * @return
	 */
	List<CommentPo> getUserComment(Long creatorId, PageInfo pageInfo);

}
