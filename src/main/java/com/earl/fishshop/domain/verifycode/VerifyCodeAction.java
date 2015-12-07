package com.earl.fishshop.domain.verifycode;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.util.VerifyServiceUtil;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 验证码.
 * @author Administrator
 * 
 */
@Controller(value = "verifyCodeAction")
@Scope(value = "prototype")
public class VerifyCodeAction extends BaseAction<VerifyCodePo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	private String verifyCode;
	
	protected ResultMessage resultMessage;
	private VerifyServiceUtil verifyServiceUtil;

	
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}


	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}


	// 下面填写业务逻辑

	/**
	 * 保存手机 验证码.
	 *@author 宋文光.
	 */
	public void addVerifyCode() {
		Boolean save = verifyCodeServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 删除验证码.
	 * @author 宋文光.
	 */
	public void deleteUnit(){
		Boolean deleteById = verifyCodeServer.deleteById(model.getVerifycodeId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(deleteById);
	}
	
	/**
     * 获取图片验证码.
     * @author 宋文光
     */
    public final void getImgVerifyCode() {
    	verifyServiceUtil = new VerifyServiceUtil();	
    	resultMessage = verifyServiceUtil.getImgVerifyCode();
    	session.put("imgVerifyCode", resultMessage.getResultInfo());
    	resultMessage.setUserToken(true);
    }
 
    /**
     * 验证输入图片验证码.
     * @author 宋文光
     */
    public void confirmImgVerifyCode() {
    	verifyServiceUtil = new VerifyServiceUtil();
    	String ImgVf = (String) session.get("imgVerifyCode");
    	verifyServiceUtil.confirmImgVerifyCode(ImgVf , verifyCode);
    	resultMessage.setUserToken(true);
    }
	
}
