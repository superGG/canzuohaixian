package com.earl.fishshop.util;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.serviceImpl.BaseServiceImpl;
import com.earl.util.SmsbaoHelper;
import com.earl.util.VerifyCodeUtil;

/**
 * 生成验证码service类.
 * 
 * @author 宋文光
 * @since 3.0.0
 */
public class VerifyServiceUtil extends  BaseServiceImpl<UserPo>{

	/**
	 * 6位数的手机验证码.
	 */
	private Integer mobileVerifyCode = null;

	/**
	 * 生成验证码.
	 * 
	 * @author 宋文光
	 * @return ResultMessage 验证码.
	 */
	public ResultMessage getImgVerifyCode() {
		ResultMessage rs = new ResultMessage();
		try {
			VerifyCodeUtil verifycode = new VerifyCodeUtil();
			BufferedImage bi = verifycode.getImage();
			VerifyCodeUtil.output(bi, new FileOutputStream("f:/a.jpg"));
			String vf = verifycode.getText();
			//TODO 验证码应该存在resultMessage中，只为了测试。图片传到客户端还没做
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
	 * @author 宋文光
	 * @param verifyCode
	 *            系统生成验证码.
	 * @param uVerifyCode
	 *            用户输入的验证码.
	 * @return ResultMessage 服务信息.
	 */
	public ResultMessage confirmImgVerifyCode(final String verifyCode,
			final String uVerifyCode) {
		ResultMessage rs = new ResultMessage();
		
		if (verifyCode == uVerifyCode) {
			rs.setServiceResult(true);
			rs.setResultInfo("验证成功");
		} else {
			rs.setServiceResult(false);
			rs.setResultInfo("验证码错误");
		}
		return rs;
	}

	/**
	 * 向指定手机号码发送验证码.
	 * 
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
		String code = Integer.toString(mobileVerifyCode);
		String mf = "【海鲜速递】您的验证码是" + code + ",60秒有效";
		System.out.println(mf);
		String content = java.net.URLEncoder.encode(mf, "utf-8");// 发送内容
		SmsbaoHelper send = new SmsbaoHelper("http://www.smsbao.com/sms?u="
				+ username + "&p=" + password + "&m=" + verifyPhone + "&c="
				+ content);
		try {
			// 结果返回0时，短信发送成功
			result = send.send();
			if (result == 0) {
				rs.setResultInfo(code);
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
	 * 查询短信宝余额.
	 * 
	 * @author 宋文光
	 * @return resulrMessage.
	 */
	public ResultMessage checkSmsbao() {
		ResultMessage rs = new ResultMessage();
		String username = "q410654146";// 短信宝帐户名
		String password = SmsbaoHelper.Md5("940507");// 短信宝账户密码

		SmsbaoHelper check = new SmsbaoHelper("http://www.smsbao.com/query?u="
				+ username + "&p=" + password);
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
