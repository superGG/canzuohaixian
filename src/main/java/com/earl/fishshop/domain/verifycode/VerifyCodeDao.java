package com.earl.fishshop.domain.verifycode;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface VerifyCodeDao extends BaseDao<VerifyCodePo>{

	/**
	 * 通过手机号码获取验证码.
	 *@author 宋文光.
	 * @param phoneNumber
	 * @return
	 */
	List<VerifyCodePo> getVerifyCode(String phoneNumber);


}
