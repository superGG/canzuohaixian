package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.BaseDao;
import com.earl.fishshop.pojo.CommentPo;
import com.earl.fishshop.service.CommentService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "commentService")
public class CommentServiceImpl extends BaseServiceImpl<CommentPo> implements
		CommentService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "commentDao")
	BaseDao commentDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = commentDao;
	}
	
}
