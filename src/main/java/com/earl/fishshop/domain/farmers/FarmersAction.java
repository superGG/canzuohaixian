package com.earl.fishshop.domain.farmers;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.MulitFileVo;
import com.earl.fishshop.vo.ResultMessage;

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

	/**
	 * 用户id.
	 */
	private Long userId;

	/**
	 * 养殖场文件.
	 */
	private MulitFileVo farmersFile;
	
	public MulitFileVo getFarmersFile() {
		return farmersFile;
	}
	public void setFarmersFile(MulitFileVo farmersFile) {
		this.farmersFile = farmersFile;
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
		if (save) {
			resultMessage.setResultInfo("操作成功");
			resultMessage.setServiceResult(save);
		} else {
			resultMessage.setResultInfo("操作失败");
			resultMessage.setServiceResult(save);
		}
	}
	
	/**
	 * 用户认证为养殖户.
	 * @author 宋文光.
	 */
	public void authenticationFarmer(){
		Boolean result = farmersServer.authenticationFarmer(userId,model,farmersFile);
		if (result) {
			resultMessage.setResultInfo("认证发送成功");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setResultInfo("认证发送失败");
			resultMessage.setServiceResult(result);
		}
	}

	/**
	 * 更新养殖户个人信息.
	 * @author 宋文光.
	 */
	public void updateFarmers(){
		Boolean result = farmersServer.updateWithNotNullProperties(model);
		if (result) {
			resultMessage.setResultInfo("操作成功");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setResultInfo("操作失败");
			resultMessage.setServiceResult(result);
		}
	}
	
	/**
	 * 查询养殖户的详细信息.
	 *@author 宋文光.
	 */
	public void getFarmers() {
		List<FarmersPo> list = farmersServer.getFarmers(model.getFarmersId());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("farmers", list);
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
		Boolean result = farmersServer.passAuthenticationFarmers(userId,model);
		if (result) {
			resultMessage.setResultInfo("成功通过认证");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setResultInfo("操作失败");
			resultMessage.setServiceResult(result);
		}
	}
	
	/**
	 * 不通过认证养殖户.
	 *@author 宋文光.
	 */
	public void noPassAuthenticationFarmers() {
		Boolean result = farmersServer.noPassAuthenticationFarmers(userId,model.getFarmersId());
		if (result) {
			resultMessage.setResultInfo("操作成功");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setResultInfo("操作失败");
			resultMessage.setServiceResult(result);
		}
	}
	
	/**
	 * 通过商店获取养殖户信息.
	 *@author 宋文光.
	 */
	public void getFarmerByShop() {
		Map<String, Object> hashMap = farmersServer.getFarmerByShop(model);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo("获取成功");
	}
	
	
}
