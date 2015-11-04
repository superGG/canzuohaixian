package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.SkuPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "skuAction")
@Scope(value = "prototype")
public class SkuAction extends BaseAction<SkuPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected SkuPo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public SkuPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		skuServer.save(model);
		SkuPo skuPo = new SkuPo();
		jsonInputStream = skuPo;
		
	}
}
