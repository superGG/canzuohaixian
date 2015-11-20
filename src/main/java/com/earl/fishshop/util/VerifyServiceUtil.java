/**
 * Copyright (c) 2007-2015 WteamFly.  All rights reserved. 网飞网络公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.earl.fishshop.util;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

import com.earl.fishshop.dao.UserDao;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.UserPo;
import com.earl.util.SmsbaoHelper;
import com.earl.util.VerifyCodeUtil;

/**
 * 生成验证码service类.
 * 
 * @author 宋文光
 * @since 3.0.0
 */
public class VerifyServiceUtil  {
	
	
	
	/**
	 * 6位数的手机验证码.
	 */
	private Integer mobileVerifyCode = null;

	
	
	
	/**
	 * 生成验证码.
	 * @author 宋文光
	 * @return ResultMessage 验证码.
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

	/**
	 * 验证输入验证码.
	 * @author 宋文光
	 * @param verifyCode
	 *            系统生成验证码.
	 * @param uVerifyCode
	 *            用户输入的验证码.
	 * @return ResultMessage 服务信息.
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

	/**
	 * 向指定手机号码发送验证码.
	 * @author 宋文光
	 * @param verifyPhone
	 *            指定手机号码.
	 * @return resulrMessage.
	 * @throws Exception
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

	/**
	 * 找回密码.
	 * @author 宋文光
	 * @param userPhone
	 *  			用户输入的手机号码.
	 * @param userName
	 * 				用户输入的用户名.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public ResultMessage findPassWord(String userPhone, String userName)
			throws Exception {
		ResultMessage rs = new ResultMessage();
		
		UserDao userDao = null;
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

	/**
	 * 查询短信宝余额.
	 * @author 宋文光
	 * @return resulrMessage.
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
	
	

}
