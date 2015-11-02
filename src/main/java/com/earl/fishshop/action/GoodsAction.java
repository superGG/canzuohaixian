package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GoodsPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "goodsAction")
@Scope(value = "prototype")
public class GoodsAction extends BaseAction<GoodsPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected GoodsPo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public GoodsPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		goodsServer.save(model);
		GoodsPo goodsPo = new GoodsPo();
		jsonInputStream = goodsPo;
		
	}
}
