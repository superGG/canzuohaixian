/**
 * Copyright (c) 2007-2015 WteamFly.  All rights reserved. 网飞网络公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.serviceImpl.VerifyCodeService;


/**
 * 验证码Action类.
 * 
 * @author 宋文光
 */
@Controller(value = "VerfyCodeAction")
@Scope(value = "prototype")
public class VerfyCodeAction extends BaseAction<UserPo>{
	
	private static final long serialVersionUID = 3293435262298029608L;
	
    /**
     * 结果信息.
     */
    protected ResultMessage resultMessage;
    
    /**
     * 手机号码.
     */
    private String uPhone;
    
    /**
     * 用户输入的验证码.
     */
    private String uVerifyCode;
    
    /**
     * @return 获取的uVerifyCode
     */
    public String getuVerifyCode() {
		return uVerifyCode;
	}

    /**
     * 设置uVerifyCode的方法.
     * 
     * @param uVerifyCode
     *            赋值给uVerifyCode的值
     */
	public void setuVerifyCode(String uVerifyCode) {
		this.uVerifyCode = uVerifyCode;
	}

	/**
     * @return 获取的uPhone
     */
	public String getUPhone() {
		return uPhone;
	}

	 /**
     * 设置uPhone的方法.
     * 
     * @param uPhone
     *            赋值给uPhone的值
     */
	public void setUPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
    
    /**
     * 获取验证码.
     */
    public final void getVerifyCode() {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	resultMessage = service.getVerifyCode();
    	session.put("verifyCode", resultMessage.getResultInfo());
    	resultMessage.setUserToken(true);
    }
    
    
    /**
     * 验证输入图片验证码.
     */
    public final void confirmImgVerifyCode() {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	final String ImgVf = (String) session.get("ImgVerifyCode");
    	resultMessage = service.confirmVerifyCode(ImgVf , uVerifyCode);
    	resultMessage.setUserToken(true);
    }
    
    /**
     * 在注册时发送验证码到手机.
     * @throws Exception 
     */
    public final void smsCodeOfRegister() throws Exception {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	resultMessage = service.sendMobileVerifyCode(uPhone);
    	session.put("smsCodeOfRegister", resultMessage.getResultInfo());
    }
    
//    /**
//     * 在找回密码时发送验证码到手机.
//     * @throws Exception 
//     * 
//     */
//    public final void smsCodeOfFound() throws Exception {
//    	final UserPo currentUserPo = currentUser.voToPo(UserPo.class);
//    	final VerifyCodeService service = VerifyCodeService.getInstance();
//    	resultMessage = service.isUserPhone(uPhone, currentUserPo);
//    	session.put("smsCodeOfFound", resultMessage.getResultInfo());
//    }
    
    /**
     * 验证输入手机验证码.
     */
    public final void confirmSmsVerifyCode() {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	final String SmsVf = (String) session.get("SmsVerifyCode");
    	resultMessage = service.confirmVerifyCode(SmsVf , uVerifyCode);
    	resultMessage.setUserToken(true);
    }
    
    

}
