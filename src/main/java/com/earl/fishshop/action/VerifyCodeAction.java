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
@Controller(value = "verfyCodeAction")
@Scope(value = "prototype")
public class VerifyCodeAction extends BaseAction<UserPo>{
	
	private static final long serialVersionUID = 3293435262298029608L;
	
    /**
     * 结果信息.
     */
    protected ResultMessage resultMessage;
    
    /**
     * 用户输入的手机号码.
     */
    private String phone;
    
    /**
     * 用户输入的验证码.
     */
    private String verifyCode;
    
    /**
     * 所要找回的用户名.
     */
    private String userName;
    
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * @return 获取的uVerifyCode
     */
    public String getVerifyCode() {
		return verifyCode;
	}

    /**
     * 设置uVerifyCode的方法.
     * 
     * @param uVerifyCode
     *            赋值给uVerifyCode的值
     */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	/**
     * @return 获取的uPhone
     */
	public String getPhone() {
		return phone;
	}

	 /**
     * 设置uPhone的方法.
     * 
     * @param uPhone
     *            赋值给uPhone的值
     */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
    
    /**
     * 获取图片验证码.
     */
    public final void getImgVerifyCode() {
    	verifyCodeService = VerifyCodeService.getInstance();
    	resultMessage = verifyCodeService.getVerifyCode();
    	session.put("imgVerifyCode", resultMessage.getResultInfo());
    	resultMessage.setUserToken(true);
    }
    
 
    /**
     * 验证输入图片验证码.
     */
    public final void confirmImgVerifyCode() {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	final String ImgVf = (String) session.get("imgVerifyCode");
    	resultMessage = service.confirmVerifyCode(ImgVf , verifyCode);
    	resultMessage.setUserToken(true);
    }
    
    /**
     * 在注册时发送验证码到手机.
     * @throws Exception 
     */
    public final void smsCodeOfRegister() throws Exception {
    	verifyCodeService = VerifyCodeService.getInstance();
    	resultMessage = verifyCodeService.sendMobileVerifyCode(phone);
    	session.put("smsVerifyCode", resultMessage.getResultInfo());
    }
    
    /**
     * 在找回密码时发送验证码到手机.
     * @throws Exception 
     * 
     */
    public final void smsCodeOfFound() throws Exception {
    	verifyCodeService = VerifyCodeService.getInstance();
    	resultMessage = verifyCodeService.findPassWord(phone, userName);
    	session.put("smsVerifyCode", resultMessage.getResultInfo());
    }
    
    /**
     * 验证输入手机验证码.
     */
    public final void confirmSmsVerifyCode() {
    	final VerifyCodeService service = VerifyCodeService.getInstance();
    	final String SmsVf = (String) session.get("smsVerifyCode");
    	resultMessage = service.confirmVerifyCode(SmsVf , verifyCode);
    	resultMessage.setUserToken(true);
    }
    

    /**
     * 查询短信余量.
     * @author 宋文光
     */
    public final void checkSmsBao() {
    	verifyCodeService = VerifyCodeService.getInstance();
    	resultMessage = verifyCodeService.checkSmsbao();
    }
    
    

}
