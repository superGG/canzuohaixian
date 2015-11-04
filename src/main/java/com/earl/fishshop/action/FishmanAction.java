package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.FishmanPo;

/**
 * 
 * 渔户对应的action. 
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

	protected FishmanPo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public FishmanPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void addFishman() {
		fishmanServer.save(model);
		FishmanPo fishmanPo = new FishmanPo();
		jsonInputStream = fishmanPo;
		
	}
}
