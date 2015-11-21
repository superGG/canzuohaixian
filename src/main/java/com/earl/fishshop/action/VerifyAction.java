package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.util.VerifyServiceUtil;


/**
 * 验证码Action类.
 * 
 * @author 宋文光
 */
@Controller(value = "verifyAction")
@Scope(value = "prototype")
public class VerifyAction extends BaseAction<UserPo>{
	
	private static final long serialVersionUID = 3293435262298029608L;
	
	/**
	 * 验证工具类.
	 */
	VerifyServiceUtil verifyServiceUtil;
	
    /**
     * 结果信息.
     */
    protected ResultMessage resultMessage;
    
    /**
     * 用户输入的验证码.
     */
    private String verifyCode;

	/**
     * @return 获取的uVerifyCode
     */
    public String getVerifyCode() {
		return verifyCode;
	}

    /**
     * 设置uVerifyCode的方法.
     * 
     * @param VerifyCode
     *            赋值给VerifyCode的值
     */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
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
    	resultMessage = verifyServiceUtil.confirmImgVerifyCode(ImgVf , verifyCode);
    	resultMessage.setUserToken(true);
    }
    
   
    
    /**
     * 验证输入手机验证码.
     * @author 宋文光
     */
    public void confirmSmsVerifyCode() {
    	verifyServiceUtil =  new VerifyServiceUtil();
    	String SmsVf = (String) session.get("smsVerifyCode");
    	resultMessage = verifyServiceUtil.confirmImgVerifyCode(SmsVf , verifyCode);
    	resultMessage.setUserToken(true);
    }
    

    /**
     * 查询短信余量.
     * @author 宋文光
     */
    public final void checkSmsBao() {
    	verifyServiceUtil = new VerifyServiceUtil();
    	resultMessage = verifyServiceUtil.checkSmsbao();
    }
    
    

}
