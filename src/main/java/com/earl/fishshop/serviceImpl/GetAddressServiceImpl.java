package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.GetAddressDao;
import com.earl.fishshop.pojo.GetAddressPo;
import com.earl.fishshop.service.GetAddressService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "getAddressService")
public class GetAddressServiceImpl extends BaseServiceImpl<GetAddressPo> implements
		GetAddressService {
//	public GoodsServiceImpl() {
//		baseDao = goodsDao;
//	}

	@Resource(name = "getAddressDao")
	GetAddressDao getAddressDao;

//	@PreDestroy
	@PostConstruct
	public void initBaseDao(){
		baseDao = getAddressDao;
	}

	@Override
	public List<GetAddressPo> getUserAllAddress(Long userId) {
		// TODO 未测试.
		List<GetAddressPo> getAddressList = getAddressDao.getUserAllAddress(userId);
		return getAddressList;
	}
	
}
