package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.dao.UserDao;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.service.UserService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<UserPo> implements
		UserService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "userDao")
	UserDao userDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = userDao;
	}
	
}
