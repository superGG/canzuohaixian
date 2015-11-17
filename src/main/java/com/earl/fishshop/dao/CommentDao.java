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

}
