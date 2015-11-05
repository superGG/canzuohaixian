package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.pojo.UserPo;

public interface UserDao extends BaseDao<UserPo>{
	/**
	 * 通过手机号码查询用户.
	 * @author 宋文光
	 * @param phoneNumber
	 * @return
	 */
	List<UserPo> getUserByPhone(String phoneNumber);

	/**
	 * 通过用户名查询用户.
	 * @author 宋文光
	 * @param userName
	 * @return
	 */
	List<UserPo> getUserByName(String userName);
	

}