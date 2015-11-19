package com.earl.fishshop.serviceImpl;

import java.util.List;

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

	@Override
	public List<FarmersPo> getFarmers(Long identityId) {
		List<FarmersPo> list = farmersDao.getFarmers(identityId);
		return list;
	}

	@Override
	public Boolean passAuthenticationFarmers(Long userId) {
		try {
			farmersDao.passAuthenticationFarmers(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean noPassAuthenticationFarmers(Long userId, Long farmersId) {
		try {
			farmersDao.noPassAuthenticationFarmers(userId);
			farmersDao.deleteById(farmersId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
