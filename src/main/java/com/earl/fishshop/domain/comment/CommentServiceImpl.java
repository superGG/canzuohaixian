package com.earl.fishshop.domain.comment;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.vo.PageInfo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "commentService")
public class CommentServiceImpl extends BaseServiceImpl<CommentPo> implements
		CommentService {

	@Resource(name = "commentDao")
	CommentDao commentDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = commentDao;
	}

	@Override
	public List<CommentPo> getShopComment(Long shopId, PageInfo pageInfo) {
		List<CommentPo> list = commentDao.getShopComment(shopId, pageInfo);
		return list;
	}

	@Override
	public List<CommentPo> getGoodComment(Long shopId, PageInfo pageInfo) {
		List<CommentPo> list = commentDao.getGoodComment(shopId, pageInfo);
		return list;
	}

	@Override
	public List<CommentPo> getMidComment(Long shopId, PageInfo pageInfo) {
		List<CommentPo> list = commentDao.getMidComment(shopId, pageInfo);
		return list;
	}

	@Override
	public List<CommentPo> getBedComment(Long shopId, PageInfo pageInfo) {
		List<CommentPo> list = commentDao.getBedComment(shopId, pageInfo);
		return list;
	}
}
