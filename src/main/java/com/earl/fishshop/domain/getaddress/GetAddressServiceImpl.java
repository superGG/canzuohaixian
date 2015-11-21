package com.earl.fishshop.domain.getaddress;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;

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
