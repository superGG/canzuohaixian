package com.earl.fishshop.domain.verifycode;

import com.earl.fishshop.domain.base.BaseService;

public interface VerifyCodeService extends BaseService<VerifyCodePo>{

	/**
	 * 保存验证码.
	 *@author 宋文光.
	 * @param verifyCodePo
	 */
	void saveVerifyCode(VerifyCodePo verifyCodePo);

	/**
	 * 通过手机号码获取验证码.
	 *@author 宋文光.
	 * @param phoneNumber
	 * @return
	 */
	String getVerifyCode(String phoneNumber);


}
