package com.earl.fishshop.domain.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.farmers.FarmersPo;
import com.earl.fishshop.domain.fishman.FishmanPo;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.util.VerifyServiceUtil;
import com.earl.fishshop.vo.MulitFileVo;
import com.earl.fishshop.vo.ResultMessage;
import com.earl.util.FileUploadImpl;
import com.earl.util.SmsbaoHelper;

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

	@Resource(name = "fileUpload")
	FileUploadImpl fileUpload;

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
	 * @return
	 * @author 宋文光
	 */
	public ResultMessage userLogin(UserPo model) {
		ResultMessage rs = new ResultMessage();
		FishmanPo fishman = null;
		FarmersPo farmer = null;
		ShopPo shop = null;
		
		if (model.getPhoneNumber() != null) { // 用户使用手机登录
			List<UserPo> userList = userDao.getUserByPhone(model
					.getPhoneNumber());
			rs = verifyPassword(userList, model.getPassword());
			if (userList.get(0).getUserType()==MyConstant.user_fishman) { //登陆用户为渔户
				fishman = fishmanDao.get(userList.get(0).getIdentityId());
				shop = shopDao.get(fishman.getShopId());
				rs.getResultParm().put("fishman", fishman);
				rs.getResultParm().put("shop", shop);
			} else if (userList.get(0).getUserType()==MyConstant.user_farmer){//登陆用户为养殖户
				farmer = farmersDao.get(userList.get(0).getIdentityId());
				shop = shopDao.get(farmer.getShopId());
				rs.getResultParm().put("farmer", farmer);
				rs.getResultParm().put("shop", shop);
			}
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
	public Boolean blackUser(UserPo user) {
		Boolean result = userDao.blackUser(user);
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
		UserPo user = userlist.get(0);
		String userPassword = SmsbaoHelper.Md5(password);
		if (userlist.size() != 0) { // 根据用户输入查询所得用户信息.
			if (userPassword.equals(user.getPassword())) { // 密码验证
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
		} else {
			rs.setResultInfo("验证失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

	/**
	 * 用户注册.
	 * 
	 * @author 宋文光
	 * @param userPhone
	 *            用户输入的手机号码.
	 * @return
	 * @throws Exception
	 */
	public ResultMessage smsCodeOfRegister(UserPo model) throws Exception {
		ResultMessage rs = new ResultMessage();
		verifyServiceUtil = new VerifyServiceUtil();

		if (model.getPhoneNumber() != null) {
			// 检测注册手机是否被注册
			List<UserPo> userList = userDao.getUserByPhone(model
					.getPhoneNumber());
			if (userList.size() == 0) {
				rs = verifyServiceUtil.sendMobileVerifyCode(model
						.getPhoneNumber());
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

	@Override
	public Boolean rigisterUser(UserPo model) {
		Boolean result;
		try {
			model.setUserName(model.getPhoneNumber());
			model.setHeadImage("user/aaa.jpg");
			model.setPassword(SmsbaoHelper.Md5(model.getPassword()));
			model.setUserType(MyConstant.user_normal);
			userDao.save(model);
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateUserImg(UserPo model, MulitFileVo userFile) {
		try {
			List<String> uploadUserFile = fileUpload.uploadUserFile(
					userFile.getFile(), userFile.getFileFileName());
			model.setHeadImage(uploadUserFile.get(0));
			userDao.updateWithNotNullProperties(model);
			return true;
		} catch (Exception e) {
			System.out.println("更新用户头像失败");
			e.printStackTrace();
		}
		return false;
	}
}
