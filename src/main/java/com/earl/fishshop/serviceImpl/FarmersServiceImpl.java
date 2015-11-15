package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.FarmersDao;
import com.earl.fishshop.pojo.FarmersPo;
import com.earl.fishshop.service.FarmersService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "farmersService")
public class FarmersServiceImpl extends BaseServiceImpl<FarmersPo> implements
		FarmersService {

	@Resource(name = "farmersDao")
	FarmersDao farmersDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = farmersDao;
	}

	@Override
	public Boolean authenticationFarmer(Long userId, FarmersPo model) {
		try {
			farmersDao.authenticationFarmers(userId,model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
