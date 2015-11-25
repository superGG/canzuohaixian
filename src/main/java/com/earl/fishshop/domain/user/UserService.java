package com.earl.fishshop.domain.user;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.vo.MuchFileVo;
import com.earl.fishshop.vo.ResultMessage;

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
	 * 注册时发验证码到指定手机.
	 *@author 宋文光.
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	ResultMessage smsCodeOfRegister(UserPo model) throws Exception;

	/**
	 * 找回密码时发验证码到指定手机.
	 *@author 宋文光.
	 * @param phoneNumber
	 * @return
	 * @throws Exception 
	 */
	ResultMessage smsCodefindPassWord(String phoneNumber) throws Exception;

	/**
	 * 用户注册.
	 *@author 宋文光.
	 * @param model
	 * @return
	 */
	Boolean rigisterUser(UserPo model);

	/**
	 * 更新用户头像.
	 *@author 宋文光.
	 * @param model
	 * @param userFileVo
	 * @return
	 */
	Boolean updateUserImg(UserPo model, MuchFileVo userFileVo);

	/**
	 * 用户登录.
	 *@author 宋文光.
	 * @param model
	 * @return
	 */
	ResultMessage userLogin(UserPo model);

}
