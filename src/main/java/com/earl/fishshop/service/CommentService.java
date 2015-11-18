package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.CommentPo;
import com.earl.fishshop.vo.PageInfo;

public interface CommentService extends BaseService<CommentPo>{

	/**
	 * 获取商店所有评论.
	 *@author 宋文光.
	 * @param shopId 商店Id.
	 * @param pageInfo 分页信息.
	 * @return
	 */
	List<CommentPo> getShopComment(Long shopId, PageInfo pageInfo);

	/**
	 * 获取商店所有好评.
	 * @author 宋文光.
	 * @param shopId
	 * @param pageInfo 
	 * @return
	 */
	List<CommentPo> getGoodComment(Long shopId, PageInfo pageInfo);
	
	/**
	 * 获取商店所有中评.
	 * @author 宋文光.
	 * @param shopId
	 * @param pageInfo 
	 * @return
	 */
	List<CommentPo> getMidComment(Long shopId, PageInfo pageInfo);
	
	/**
	 * 获取商店所有差评.
	 * @author 宋文光.
	 * @param shopId
	 * @param pageInfo 
	 * @return
	 */
	List<CommentPo> getBedComment(Long shopId, PageInfo pageInfo);

	

	
	
	
}
