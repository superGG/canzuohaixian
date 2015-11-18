package com.earl.fishshop.dao;


import java.util.List;

import com.earl.fishshop.base.BaseDao;
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
	 * 拉黑指定用户.
	 *@author 宋文光.
	 * @param identityId
	 * @return
	 */
	Boolean blackUser(Long identityId);
	

}
