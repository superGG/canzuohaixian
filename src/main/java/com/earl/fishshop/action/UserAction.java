package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
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

	protected UserPo jsonInputStream;
	
	protected UserPo model;

	@ReturnValue //返回实体对象，或者其他任意对象
	public UserPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		userServer.save(model);
		UserPo userPo = new UserPo();
		jsonInputStream = userPo;
		
	}
}
