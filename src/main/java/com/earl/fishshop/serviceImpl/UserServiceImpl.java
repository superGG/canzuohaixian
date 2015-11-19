package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

	@Resource(name = "userDao")
	UserDao userDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = userDao;
	}

	/**
	 * 通过手机号码查询用户.
	 * @author 宋文光
	 * @param phoneNumber
	 * @return
	 */
	@Override
	public List<UserPo> getUserByPhone(String phoneNumber) {
		List<UserPo> userList = userDao.getUserByPhone(phoneNumber);
		return userList;
	}

	/**
	 * 通过用户名查询用户.
	 * @author 宋文光
	 * @param userName
	 * @return
	 */
	@Override
	public List<UserPo> getUserByName(String userName) {
		List<UserPo> userList = userDao.getUserByName(userName);
		return userList;
	}

	/**
	 * 通过用户名查询手机号码.
	 * @author 宋文光
	 * @param userName
	 * @return
	 */
	@Override
	public String getPhoneByName(String userName) {
		List<UserPo> userList = userDao.getUserByName(userName);
		String phone = userList.get(0).getPhoneNumber();
		return phone;
	}

	@Override
	public List<UserPo> getAllFishmanUser() {
		List<UserPo> userList = userDao.getAllFishmanUser();
		return userList;
	}

	@Override
	public List<UserPo> getAllFarmersUser() {
		List<UserPo> userList = userDao.getAllFarmersUser();
		return userList;
	}

	@Override
	public Boolean blackUser(Long identityId) {
		Boolean result = userDao.blackUser(identityId);
		return result;
	}
	
}
