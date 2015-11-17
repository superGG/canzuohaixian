package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.FishmanPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 渔户对应的action. 
 * @author Administrator
 * 
 */
@Controller(value = "fishmanAction")
@Scope(value = "prototype")
public class FishmanAction extends BaseAction<FishmanPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	private Long userId;
	
	/*
	 * 外键id.
	 */
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

	// 下面填写业务逻辑
	/**
	 * 添加渔户个人信息.
	 * @author 黄祥谦.
	 */
	public void addFishman() {
		Boolean result = fishmanServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 更新渔户个人信息.
	 * @author 黄祥谦.
	 */
	public void updateFishman(){
		Boolean result = fishmanServer.update(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
		
	}
	
	/**
	 * 用户认证为渔户.
	 * @author 黄祥谦.
	 */
	public void authenticationFishman(){
		Boolean result = fishmanServer.authenticationFishman(userId,model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 查询渔户的详细信息.
	 *@author 宋文光.
	 */
	public void getFiahman() {
		List<FishmanPo> list = fishmanServer.getFishman(identityId);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("fiashman", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
}
