package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.ResultMessage;
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
		Boolean update = userServer.update(model);
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
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("userList", userList);
		resultMessage.setResultParm(hashMap);
	}
	
	
	
}
