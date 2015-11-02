package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.UnitPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "unitAction")
@Scope(value = "prototype")
public class UnitAction extends BaseAction<UnitPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected UnitPo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public UnitPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		unitServer.save(model);
		UnitPo unitPo = new UnitPo();
		jsonInputStream = unitPo;
		
	}
}
