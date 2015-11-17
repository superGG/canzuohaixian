package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.FarmersPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 养殖户Action.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "farmersAction")
@Scope(value = "prototype")
public class FarmersAction extends BaseAction<FarmersPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	private Long userId;
	
	private Long identityId;
	
	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	public void addFarmers() {
		Boolean save = farmersServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 用户认证为养殖户.
	 * @author 宋文光.
	 */
	public void authenticationFishman(){
		Boolean result = farmersServer.authenticationFarmer(userId,model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 查询渔户的详细信息.
	 *@author 宋文光.
	 */
	public void getFarmers() {
		List<FarmersPo> list = farmersServer.getFarmers(identityId);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("farmers", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
}
