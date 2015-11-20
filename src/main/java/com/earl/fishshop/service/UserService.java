package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.UserPo;

public interface UserService extends BaseService<UserPo>{

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
	
	/**
	 * 通过用户名查询手机号码.
	 * @author 宋文光
	 * @param userName
	 * @return
	 */
	String getPhoneByName(String userName);

	/**
	 * 获取所有渔户的用户信息.
	 *@author 宋文光.
	 * @return
	 */
	List<UserPo> getAllFishmanUser();

	/**
	 * 获取所有养殖户的用户信息.
	 *@author 宋文光.
	 * @return
	 */
	List<UserPo> getAllFarmersUser();

	/**
	 * 拉黑用户.
	 *@author 宋文光.
	 * @param identityId
	 * 			渔户或养殖户id;
	 * @return
	 */
	Boolean blackUser(Long identityId);

	/**
	 * 用户登陆.
	 *@author 宋文光.
	 * @param phoneNumber
	 * @param userName
	 * @param password
	 * @return
	 */
	ResultMessage userLogin(String phoneNumber, String userName, String password);

}
