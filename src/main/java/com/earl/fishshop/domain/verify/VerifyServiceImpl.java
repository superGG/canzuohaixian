package com.earl.fishshop.domain.verify;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.domain.user.UserDao;
import com.earl.fishshop.domain.user.UserPo;
import com.earl.fishshop.vo.ResultMessage;
import com.earl.util.SmsbaoHelper;
import com.earl.util.VerifyCodeUtil;

/**
 * 生成验证码service类.
 * 
 * @author 宋文光
 * @since 3.0.0
 */
public class VerifyServiceImpl extends BaseServiceImpl<UserPo> {
	/**
	 * 单例对象.
	 */
	private static VerifyServiceImpl instance = new VerifyServiceImpl();

	/**
	 * 单例模式的私有构造方法.
	 */
	private VerifyServiceImpl() {
	}

	@Resource
	UserDao userDao;
	/**
	 * 获取单例.
	 * 
	 * @return 单例
	 */
	public static VerifyServiceImpl getInstance() {
		return instance;
	}

	/**
	 * 6位数的手机验证码.
	 */
	private Integer mobileVerifyCode = null;

	
	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#userLogin(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ResultMessage userLogin(String userPhone, String userName, String password) {
		ResultMessage rs = new ResultMessage();
		if (userPhone != null) {  //用户使用手机登录
			List<UserPo> userList = userDao.getUserByPhone(userPhone);
			rs = verifyPassword(userList.get(0), password);
		} else if (userName != null ){   //用户使用 用户名登录
			List<UserPo> userList = userDao.getUserByName(userName);
			rs = verifyPassword(userList.get(0), password);
		} else {
			rs.setResultInfo("验证失败");
			rs.setServiceResult(false);
		}
		return rs;
	}
	
	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#getVerifyCode()
	 */
	public ResultMessage getVerifyCode() {
		ResultMessage rs = new ResultMessage();
		try {
			VerifyCodeUtil verifycode = new VerifyCodeUtil();
			BufferedImage bi = verifycode.getImage();
			VerifyCodeUtil.output(bi, new FileOutputStream("f:/a.jpg"));
			String vf = verifycode.getText();
			rs.setResultInfo(vf);
			rs.setServiceResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setServiceResult(false);
		}
		return rs;
	}

	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#confirmVerifyCode(java.lang.String, java.lang.String)
	 */
	public ResultMessage confirmVerifyCode(final String verifyCode,
			final String uVerifyCode) {
		ResultMessage rs = new ResultMessage();
		rs.setServiceResult(false);
		if (verifyCode == uVerifyCode) {
			rs.setServiceResult(true);
		}
		return rs;
	}

	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#sendMobileVerifyCode(java.lang.String)
	 */
	public ResultMessage sendMobileVerifyCode(String verifyPhone)
			throws Exception {
		ResultMessage rs = new ResultMessage();
		int result = -1;
		String username = "q410654146";// 短信宝帐户名
		String password = SmsbaoHelper.Md5("940507");// 短信宝账户密码

		// 生成6位数验证码
		Random random = new Random();
		mobileVerifyCode = random.nextInt(899999) + 100000;
		// 生成指定短信
		String mf = "【海洋餐桌】您的验证码是" + Integer.toString(mobileVerifyCode)
				+ ",60秒有效";
		System.out.println(mf);
		String content = java.net.URLEncoder.encode(mf, "utf-8");// 发送内容
		SmsbaoHelper send = new SmsbaoHelper(
				"http://www.smsbao.com/sms?u=" + username + "&p=" + password
						+ "&m=" + verifyPhone + "&c=" + content);
		try {
			//结果返回0时，短信发送成功
			result = send.send(); 
			if (result == 0) {
				rs.setResultInfo(mf);
				rs.setServiceResult(true);
			} else {
				rs.setResultInfo("生成失败");
				rs.setServiceResult(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rs.setResultInfo("生成失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#findPassWord(java.lang.String, java.lang.String)
	 */
	public ResultMessage findPassWord(String userPhone, String userName)
			throws Exception {
		ResultMessage rs = new ResultMessage();
		if (userPhone != null) {
			List<UserPo> userList = userDao.getUserByPhone(userPhone);
			if(userList.get(0) != null) {
				rs = sendMobileVerifyCode(userPhone);
			} else {
				rs.setResultInfo("无此用户");
				rs.setServiceResult(false);
			}
		} else if (userName != null ){
			List<UserPo> userList = userDao.getUserByName(userName);
			//通过用户名查询用户返回用户名手机号且发送短信到该手机号
			if(userList.get(0) != null) {
				rs = sendMobileVerifyCode(userList.get(0).getPhoneNumber());
			} else {
				rs.setResultInfo("无此用户");
				rs.setServiceResult(false);
			}
		} else {
			rs.setResultInfo("验证失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#checkSmsbao()
	 */
	public ResultMessage checkSmsbao(){
		ResultMessage rs = new ResultMessage();
		String username = "q410654146";// 短信宝帐户名
		String password = SmsbaoHelper.Md5("940507");// 短信宝账户密码

		SmsbaoHelper check = new SmsbaoHelper(
				"http://www.smsbao.com/query?u=" + username + "&p=" + password);
		try {
			int remain = check.check();
			if (remain >= 0) {
				rs.setResultInfo(String.valueOf(remain));
				rs.setServiceResult(true);
			} else {
				rs.setResultInfo("查询失败");
				rs.setServiceResult(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rs.setResultInfo("查询失败");
			rs.setServiceResult(false);
		}
		return rs;
	}
	
	/* (non-Javadoc)
	 * @see com.earl.fishshop.serviceImpl.VerifyService#verifyPassword(com.earl.fishshop.pojo.UserPo, java.lang.String)
	 */
	public ResultMessage verifyPassword(UserPo userPo, String password) {
		ResultMessage rs = new ResultMessage();
		if(userPo != null) { //根据用户输入查询所得用户信息.
			if(password == userPo.getPassword()) { //密码验证
				rs.setServiceResult(true);
				rs.setResultInfo("登陆成功");
				List<UserPo> list = new ArrayList<UserPo>();
				list.add(userPo);
				Map<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("user", list);
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

}
