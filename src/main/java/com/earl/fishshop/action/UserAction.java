package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.pojo.UserPo;

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

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	/**
	 * 用户身份id.
	 */
	private Long identityId;
	

	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	// 下面填写业务逻辑
	/**
	 * 添加用户.
	 * @author 宋文光
	 */
	public void addUser() {
		Boolean save = userServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 更新用户信息.
	 * @author 宋文光
	 */
	public void updateUser() {
		Boolean update = userServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 删除用户信息.
	 * @author 宋文光
	 */
	public void deleteUser() {
		Boolean delete = userServer.deleteById(model.getUserId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(delete);
	}
	
	/**
	 * 获取所有用户.
	 * @author 宋文光
	 */
	public void findAllUser() {
		List<UserPo> userList = userServer.findAll();
		resultMessage = new ResultMessage();
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("userList", userList);
		resultMessage.setResultParm(hashMap);
	}
	
	/**
	 * 用户登录验证.
	 * @author 宋文光
	 */
	public final void userLogin() {
		resultMessage = userServer.userLogin(model.getPhoneNumber()
								, model.getUserName()
								, model.getPassword());
	}
	
	/**
	 * 获取所有用户数量.
	 * @author 宋文光
	 */
	public void findAllUserNumber() {
		List<UserPo> userList = userServer.findAll();
		String userNamber = String.valueOf(userList.size());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo(userNamber);
	}
	
	
	/**
	 * 得到我的商店信息.
	 * @author 黄祥谦.
	 */
	public void getMyShop() {
		ShopPo shop = shopServer.getMyShop(model.getUserId());
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("shop", shop);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 获取所有渔户的用户信息.
	 *@author 宋文光.
	 */
	public void getAllFishmanUser() {
		List<UserPo> userList = userServer.getAllFishmanUser();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("fishmanUser", userList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 获取所有养殖户的用户信息.
	 *@author 宋文光.
	 */
	public void getAllFarmersUser() {
		List<UserPo> userList = userServer.getAllFarmersUser();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("farmersUser", userList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 用户注册.
	 *@author 宋文光.
	 */
	public void registerUser() {
		resultMessage = new ResultMessage();
		if (userServer.getUserByName(model.getUserName()) != null){
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("用户已存在");
		} else if (userServer.getUserByPhone(model.getPhoneNumber()) != null) {
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("用户已存在");
		} else {
			userServer.save(model);
			resultMessage.setServiceResult(true);
			resultMessage.setResultInfo("注册成功");
		}
	}
	
	/**
	 * 拉黑用户.
	 *@author 宋文光.
	 */
	public void blackUser() {
		resultMessage = new ResultMessage();
		Boolean success = userServer.blackUser(identityId);
		if (success) {
			resultMessage.setServiceResult(success);
			resultMessage.setResultInfo("拉黑成功");
		} else {
			resultMessage.setServiceResult(false);
			resultMessage.setResultInfo("拉黑出错");
		}
	}
	
}
