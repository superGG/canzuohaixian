package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.FishmanDao;
import com.earl.fishshop.pojo.FishmanPo;
import com.earl.fishshop.service.FishmanService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "fishmanService")
public class FishmanServiceImpl extends BaseServiceImpl<FishmanPo> implements
		FishmanService {

	@Resource(name = "fishmanDao")
	FishmanDao fishmanDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = fishmanDao;
	}

	@Override
	public Boolean authenticationFishman(Long userId, FishmanPo model) {
		// TODO 未测试.
		try {
			fishmanDao.authenticationFishman(userId,model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<FishmanPo> getFishman(Long identityId) {
		List<FishmanPo> list = fishmanDao.getFishman(identityId);
		return list;
	}

	@Override
	public Boolean passAuthenticationFishman(Long userId) {
		try {
			fishmanDao.passAuthenticationFishman(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean noPassAuthenticationFishman(Long userId, Long fishmanId) {
		try {
			fishmanDao.noPassAuthenticationFishman(userId);
//			fishmanDao.deleteById(fishmanId); //删除渔户
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
