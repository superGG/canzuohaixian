package com.earl.fishshop.domain.farmers;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
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
	 * 更新养殖户个人信息.
	 * @author 宋文光.
	 */
	public void updateFarmers(){
		Boolean result = farmersServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 查询养殖户的详细信息.
	 *@author 宋文光.
	 */
	public void getFarmers() {
		List<FarmersPo> list = farmersServer.getFarmers(model.getFarmersId());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("farmers", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 获取所有养殖户数量.
	 * @author 宋文光
	 */
	public void findAllFarmersNumber() {
		List<FarmersPo> farmersList = farmersServer.findAll();
		String farmersNamber = String.valueOf(farmersList.size());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo(farmersNamber);
	}
	
	/**
	 * 通过认证养殖户.
	 *@author 宋文光.
	 */
	public void passAuthenticationFarmers() {
		Boolean result = farmersServer.passAuthenticationFarmers(userId);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
	
	/**
	 * 不通过认证养殖户.
	 *@author 宋文光.
	 */
	public void noPassAuthenticationFarmers() {
		Boolean result = farmersServer.noPassAuthenticationFarmers(userId,model.getFarmersId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}
}
