package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GetTypePo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "getTypeAction")
@Scope(value = "prototype")
public class GetTypeAction extends BaseAction<GetTypePo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected GetTypePo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public GetTypePo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		getTypeServer.save(model);
		GetTypePo getTypePo = new GetTypePo();
		jsonInputStream = getTypePo;
		
	}
}
