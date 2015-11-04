/**
 * Copyright (c) 2007-2015 WteamFly.  All rights reserved. 网飞网络公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.earl.fishshop.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import com.earl.fishshop.pojo.ResultMessage;
import com.earl.util.SmsbaoHelper;
import com.earl.util.VerifyCodeUtil;

/**
 * 生成验证码service类.
 * 
 * @author 宋文光
 * @since 3.0.0
 */
public class VerifyCodeService {
	/**
	 * 单例对象.
	 */
	private static VerifyCodeService instance = new VerifyCodeService();

	/**
	 * 单例模式的私有构造方法.
	 */
	private VerifyCodeService() {
	}

	/**
	 * 获取单例.
	 * 
	 * @return 单例
	 */
	public static VerifyCodeService getInstance() {
		return instance;
	}

	/**
	 * 6位数的手机验证码.
	 */
	private Integer mobileVerifyCode = null;

	/**
	 * 生成验证码.
	 * 
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
	 * 
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
	 * 
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

//	/**
//	 * 验证是否注册手机号码.
//	 * 
//	 * @param uPhone
//	 *            用户填写手机号码.
//	 * @param currentUserPo
//	 *            用户信息.
//	 * @return resultMessage.
//	 * @throws Exception
//	 */
//	public ResultMessage isUserPhone(String uPhone, UserPo currentUserPo)
//			throws Exception {
//		ResultMessage rs = new ResultMessage();
//		BaseDaoImpl daoProxy = new BaseDaoImpl();
//		@SuppressWarnings("unchecked")
//		List<UserPo> list = (List<UserPo>) daoProxy.queryList(currentUserPo);
//		if (uPhone == list.get(0).getPhone()) {
//			sendMobileVerifyCode(uPhone);
//		} else {
//			rs.setServiceResult(false);
//		}
//		return rs;
//	}

	/**
	 * 查询短信宝余额.
	 * 
	 * @return resulrMessage.
	 */
	public ResultMessage checkSmsbao(){
		ResultMessage rs = new ResultMessage();
		String username = "q410654146";// 短信宝帐户名
		String password = SmsbaoHelper.Md5("940507");// 短信宝账户密码

		SmsbaoHelper check = new SmsbaoHelper(
				"http://www.smsbao.com/query?u=" + username + "&p=" + password);
		try {
			check.check();
			rs.setServiceResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setResultInfo("生成失败");
			rs.setServiceResult(false);
		}
		return rs;
	}

}
