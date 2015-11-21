package com.earl.fishshop.domain.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.util.VerifyServiceUtil;
import com.earl.fishshop.vo.ResultMessage;

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
	public void initBaseDao() {
		baseDao = userDao;
	}

	VerifyServiceUtil verifyServiceUtil;
	/**
	 * 通过手机号码查询用户.
	 * 
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
	 * 
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
	 * 用户登录验证.
	 * 
	 * @param userPhone
	 *            用户登录的手机.
	 * @param userName
	 *            用户登录的用户名.
	 * @param password
	 *            用户登录的密码.
	 * @return
	 * @author 宋文光
	 */
	public ResultMessage userLogin(String userPhone, String userName,
			String password) {
		ResultMessage rs = new ResultMessage();
		if (userPhone != null) { // 用户使用手机登录
			List<UserPo> userList = userDao.getUserByPhone(userPhone);
			rs = verifyPassword(userList, password);
		} else if (userName != null) { // 用户使用 用户名登录
			List<UserPo> userList = userDao.getUserByName(userName);
			rs = verifyPassword(userList, password);
		} else {
			rs.setResultInfo("验证失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

	/**
	 * 通过用户名查询手机号码.
	 * 
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

	/**
	 * 验证用户登录密码.
	 * 
	 * @author 宋文光
	 * @param userPo
	 *            用户信息.
	 * @param password
	 *            用户输入密码.
	 * @return
	 */
	public ResultMessage verifyPassword(List<UserPo> userlist, String password) {
		ResultMessage rs = new ResultMessage();
		if (userlist.size() != 0) { // 根据用户输入查询所得用户信息.
			if (password.equals(userlist.get(0).getPassword())) { // 密码验证
				rs.setServiceResult(true);
				rs.setResultInfo("登陆成功");
				Map<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("user", userlist);
				rs.setResultParm(hashMap);
			} else {
				rs.setResultInfo("密码错误");
				rs.setServiceResult(false);
			}
		} else {
			rs.setResultInfo("无此用户");
			rs.setServiceResult(false);
		}
		return rs;
	}
	
	/**
	 * 找回密码.
	 * 
	 * @author 宋文光
	 * @param userPhone
	 *            用户输入的手机号码.
	 * @param userName
	 *            用户输入的用户名.
	 * @return
	 * @throws Exception
	 */
	public ResultMessage smsCodefindPassWord(String userPhone) throws Exception {
		ResultMessage rs = new ResultMessage();
		verifyServiceUtil = new VerifyServiceUtil();
		
		if (userPhone != null) {
			List<UserPo> userList = userDao.getUserByPhone(userPhone);
			if (userList.size() != 0) {
				rs = verifyServiceUtil.sendMobileVerifyCode(userPhone);
			} else {
				rs.setResultInfo("该手机无注册用户");
				rs.setServiceResult(false);
			}
			// }
			// else if (userName != null ){
			// List<UserPo> userList = userDao.getUserByName(userName);
			// //通过用户名查询用户返回用户名手机号且发送短信到该手机号
			// if(userList.size() != 0) {
			// rs = sendMobileVerifyCode(userList.get(0).getPhoneNumber());
			// } else {
			// rs.setResultInfo("无此用户");
			// rs.setServiceResult(false);
			// }
		} else {
			rs.setResultInfo("验证失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

	/**
	 * 用户注册.
	 * @author 宋文光
	 * @param userPhone
	 *            用户输入的手机号码.
	 * @return
	 * @throws Exception
	 */
	public ResultMessage smsCodeOfRegister(String userPhone) throws Exception {
		ResultMessage rs = new ResultMessage();
		verifyServiceUtil = new VerifyServiceUtil();
		
		if (userPhone != null) {
			//检测注册手机是否被注册
			List<UserPo> userList = userDao.getUserByPhone(userPhone);
			if (userList.size() == 0) {
				rs = verifyServiceUtil.sendMobileVerifyCode(userPhone);
			} else {
				rs.setResultInfo("该手机已被注册");
				rs.setServiceResult(false);
			}
		} else {
			rs.setResultInfo("注册失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

}
