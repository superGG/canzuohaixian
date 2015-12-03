	package com.earl.fishshop.domain.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.domain.verifycode.VerifyCodePo;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.util.VerifyServiceUtil;
import com.earl.fishshop.vo.MulitFileVo;
import com.earl.fishshop.vo.ResultMessage;
import com.earl.util.SmsbaoHelper;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "userAction")
@Scope(value = "prototype")
public class UserAction extends BaseAction<UserPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;
	
	/**
	 * 验证工具欸.
	 */
	protected VerifyServiceUtil verifyServiceUtil;
	
	/**
	 * 用户上传文件.
	 */
	private MulitFileVo userFile;
	
	/**
	 * 用户输入的验证码.
	 */
	private VerifyCodePo verifyCodePo;
	
	public VerifyCodePo getVerifyCodePo() {
		return verifyCodePo;
	}

	public void setVerifyCodePo(VerifyCodePo verifyCodePo) {
		this.verifyCodePo = verifyCodePo;
	}

	public MulitFileVo getUserFile() {
		return userFile;
	}

	public void setUserFile(MulitFileVo userFile) {
		this.userFile = userFile;
	}


	/**
	 * 用户输入的验证码.
	 */
	private String verifyCode; 
	
	
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@ReturnValue
	// 返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑
	/**
	 * 添加用户(注册).
	 * 
	 * @author 宋文光
	 */
	public void addUser() {
		verifyServiceUtil =  new VerifyServiceUtil();
		resultMessage = new ResultMessage();
		
		String SmsVf = verifyCodeServer.getVerifyCode(model.getPhoneNumber());
    	Boolean result = verifyServiceUtil.confirmImgVerifyCode(SmsVf , verifyCode);
		if (result) {
			Boolean save = userServer.rigisterUser(model);
			resultMessage.setResultInfo("注册成功");
			resultMessage.setServiceResult(save);
		} else {
			resultMessage.setResultInfo("验证码错误");
			resultMessage.setServiceResult(result);
		}
	}

	/**
	 * 更新用户信息.
	 * 
	 * @author 宋文光
	 */
	public void updateUser() {
		Boolean update = userServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 更新用户头像(客户端).
	 * 
	 * @author 宋文光
	 */
	public void updateUserImg() {
		Boolean update = userServer.updateUserImg(model,userFile);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}

	/**
	 * 删除用户信息.
	 * 
	 * @author 宋文光
	 */
	public void deleteUser() {
		Boolean delete = userServer.deleteById(model.getUserId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(delete);
	}

	/**
	 * 获取所有用户.
	 * 
	 * @author 宋文光
	 */
	public void findAllUser() {
		List<UserPo> userList = userServer.findAll();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userList", userList);
		hashMap.put("number", userList.size());
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * 获取等待审核的渔户.
	 *@author 宋文光.
	 */
	public void getVerifyFishman() {
		model.setState(MyConstant.user_wait);
		model.setUserType(MyConstant.user_fishman);
		List<UserPo> userlist = userServer.findByGivenCreteria(model);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userlist", userlist);
		hashMap.put("number", userlist.size());
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * 获取等待审核的养殖户.
	 *@author 宋文光.
	 */
	public void getVerifyFarmers() {
		model.setState(MyConstant.user_wait);
		model.setUserType(MyConstant.user_farmer);
		List<UserPo> userlist = userServer.findByGivenCreteria(model);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userlist", userlist);
		hashMap.put("number", userlist.size());
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
	}

	/**
	 * 用户登录验证.
	 * 
	 * @author 宋文光
	 */
	public final void userLogin() {
		resultMessage = userServer.userLogin(model);
	}

	/**
	 * 得到我的商店信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void getMyShop() {
		ShopPo shop = shopServer.getMyShop(model.getUserId());
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("shop", shop);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	 /**
     * 在注册时发送验证码到手机.
     * @throws Exception 
     * @author 宋文光
     * @throws java.lang.Exception 
     */
    public final void smsCodeOfRegister() throws java.lang.Exception {
    	resultMessage = userServer.smsCodeOfRegister(model);
    	System.out.println("验证码："+ resultMessage.getResultInfo());
    	if (resultMessage.getServiceResult()) {
    		verifyCodePo = new VerifyCodePo();
    		verifyCodePo.setVerifyCode(resultMessage.getResultInfo());
    		verifyCodePo.setPhoneNumber(model.getPhoneNumber());
    		verifyCodeServer.saveVerifyCode(verifyCodePo);
    		resultMessage.setResultInfo("发送成功");
    	} 
    }
    
    /**
     * 在找回密码时发送验证码到手机.
     * @throws Exception 
     * @author 宋文光
     * @throws java.lang.Exception 
     */
    public final void smsCodeOfFound() throws java.lang.Exception  {
    	resultMessage = userServer.smsCodefindPassWord(model.getPhoneNumber());
    	System.out.println("验证码："+ resultMessage.getResultInfo());
    	if (resultMessage.getServiceResult()) {
    		verifyCodePo = new VerifyCodePo();
    		verifyCodePo.setVerifyCode(resultMessage.getResultInfo());
    		verifyCodePo.setPhoneNumber(model.getPhoneNumber());
    		verifyCodeServer.saveVerifyCode(verifyCodePo);
    		resultMessage.setResultInfo("发送成功");
    	} 
    }
    
    /**
     * 验证输入手机验证码.
     * @author 宋文光
     */
    public void confirmSmsVerifyCode() {
    	verifyServiceUtil =  new VerifyServiceUtil();
    	resultMessage = new ResultMessage();
    	String SmsVf = verifyCodeServer.getVerifyCode(model.getPhoneNumber());
    	Boolean result = verifyServiceUtil.confirmImgVerifyCode(SmsVf , verifyCode);
    	if ( result ) {
    		resultMessage.setServiceResult(result);
    		resultMessage.setResultInfo("验证成功");
    	} else {
    		resultMessage.setServiceResult(result);
    		resultMessage.setResultInfo("验证码错误");
    	}
    }
    
    /**
     * 找回密码时修改密码.
     * @author 宋文光.
     */
    public void findPassword() {
    	resultMessage = new ResultMessage();
    	UserPo userPo  = userServer.getUserByPhone(model.getPhoneNumber());
    	String newPassword = SmsbaoHelper.Md5(model.getPassword());//加密
    	userPo.setPassword(newPassword);
    	Boolean update = userServer.update(userPo);
    	if(update){
    		resultMessage.setServiceResult(update);
    		resultMessage.setResultInfo("更新成功");
    	} else {
    		resultMessage.setServiceResult(update);
    		resultMessage.setResultInfo("更新失败");
    	}
    }

	/**
	 * 拉黑用户.
	 * 
	 * @author 宋文光.
	 */
	public void blackUser() {
		resultMessage = new ResultMessage();
		Boolean success = userServer.blackUser(model);
		if (success) {
			resultMessage.setServiceResult(success);
			resultMessage.setResultInfo("拉黑成功");
		} else {
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("拉黑失败");
		}
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
