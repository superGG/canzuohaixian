package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.SordersPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "sordersAction")
@Scope(value = "prototype")
public class SordersAction extends BaseAction<SordersPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected SordersPo jsonInputStream;
	protected SordersPo model;

	@ReturnValue //返回实体对象，或者其他任意对象
	public SordersPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		sordersServer.save(model);
		SordersPo sordersPo = new SordersPo();
		jsonInputStream = sordersPo;
		
	}
}
