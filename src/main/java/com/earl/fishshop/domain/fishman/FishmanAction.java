package com.earl.fishshop.domain.fishman;

import java.util.HashMap;
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
 * 渔户对应的action.
 * 
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

	private MulitFileVo fishmanFile;

	private Long userId;

	public MulitFileVo getFishmanFile() {
		return fishmanFile;
	}

	public void setFishmanFile(MulitFileVo fishmanFile) {
		this.fishmanFile = fishmanFile;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	protected ResultMessage resultMessage;

	@ReturnValue
	// 返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑
	/**
	 * 添加渔户个人信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void addFishman() {
		Boolean result = fishmanServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}

	/**
	 * 更新渔户个人信息.
	 * 
	 * @author 黄祥谦.
	 */
	public void updateFishman() {
		Boolean result = fishmanServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}

	/**
	 * 用户认证为渔户.
	 * 
	 * @author 宋文光.
	 */
	public void authenticationFishman() {
		resultMessage = new ResultMessage();
		Boolean result = fishmanServer.authenticationFishman(userId, model,fishmanFile);
		if(result) {
			resultMessage.setResultInfo("认证发送成功");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setServiceResult(result);	
			resultMessage.setResultInfo("认证发送失败");
		}
	}

	/**
	 * 查询渔户的详细信息.
	 * 
	 * @author 宋文光.
	 */
	public void getFiahman() {
		List<FishmanPo> list = fishmanServer.getFishman(model.getFishmanId());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("fiashman", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 获取所有渔户数量.
	 * 
	 * @author 宋文光
	 */
	public void findAllFiahmanNumber() {
		List<FishmanPo> fishmanList = fishmanServer.findAll();
		String fishmanNamber = String.valueOf(fishmanList.size());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo(fishmanNamber);
	}

	/**
	 * 通过认证渔户.
	 * 
	 * @author 宋文光.
	 */
	public void passAuthenticationFishman() {
		resultMessage = new ResultMessage();
		Boolean result = fishmanServer.passAuthenticationFishman(userId,model);
		if (result) {
			resultMessage.setResultInfo("成功通过认证");
			resultMessage.setServiceResult(result);
		} else {
			resultMessage.setResultInfo("操作失败");
			resultMessage.setServiceResult(result);
		}
		
		
	}

	/**
	 * 不通过认证渔户.
	 * 
	 * @author 宋文光.
	 */
	public void noPassAuthenticationFishman() {
		Boolean result = fishmanServer.noPassAuthenticationFishman(userId,
				model.getFishmanId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(result);
	}

	/**
	 * 通过渔户商店详细信息.
	 *@author 宋文光.
	 */
	public void getFishmanByShop() {
		Map<String, Object> hashMap = fishmanServer.getFishmanByShop(model);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo("获取成功");
	}
}
