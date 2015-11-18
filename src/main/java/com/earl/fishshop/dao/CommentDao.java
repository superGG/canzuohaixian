package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.CommentPo;

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

}
