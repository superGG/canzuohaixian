package com.earl.fishshop.domain.user;


import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface UserDao extends BaseDao<UserPo>{
	/**
	 * 通过手机号码查询用户.
	 * @author 宋文光
	 * @param phoneNumber
	 * @return
	 */
	UserPo getUserByPhone(String phoneNumber);

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
	 * @param user
	 * @return
	 */
	Boolean blackUser(UserPo user);

	/**
	 * 获取所有用户信息（后台）
	 *@author 宋文光.
	 * @return
	 */
	List<UserPo> findAllUser();

	/**
	 * 通过渔户获取用户(后台).
	 *@author 宋文光.
	 * @param fishmanId
	 * @return
	 */
	UserPo getUserByFishmen(Long fishmanId);

	/**
	 * 通过养殖户户获取用户(后台).
	 *@author 宋文光.
	 * @param fishmanId
	 * @return
	 */
	UserPo getUserByfarmers(Long farmersId);
	

}
