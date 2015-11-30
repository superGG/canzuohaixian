package com.earl.fishshop.domain.getaddress;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.user.UserPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "getAddressService")
public class GetAddressServiceImpl extends BaseServiceImpl<GetAddressPo> implements
		GetAddressService {

	@Resource(name = "getAddressDao")
	GetAddressDao getAddressDao;

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

	@Override
	public Boolean addGetAddress(GetAddressPo model) {
		// TODO 未测试.
		try {
			getAddressDao.addGetAddress(model);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public Boolean updateUserAddress(Long getAddressId, Long userId) {
		// TODO 未测试.
		try {
			getAddressDao.updateUserAddress(getAddressId,userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteGetAddress(Long getAddressId) {
		// TODO 未测试.
		try {
			GetAddressPo getAddressPo = getAddressDao.get(getAddressId);
			UserPo userPo = userDao.get(getAddressPo.getUserId());
			if(userPo.getGetAddressId() != getAddressId){
				getAddressDao.deleteById(getAddressId);
			}else{
				GetAddressPo getAddress = getAddressDao.getFirst(userPo.getUserId());
				userPo.setGetAddressId(getAddress.getGetAddressId());
				userDao.update(userPo);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
