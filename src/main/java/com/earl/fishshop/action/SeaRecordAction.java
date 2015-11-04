package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.SeaRecordPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "seaRecordAction")
@Scope(value = "prototype")
public class SeaRecordAction extends BaseAction<SeaRecordPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected SeaRecordPo jsonInputStream;

	@ReturnValue //返回实体对象，或者其他任意对象
	public SeaRecordPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	public void save() {
		seaRecordServer.save(model);
		SeaRecordPo seaRecordPo = new SeaRecordPo();
		jsonInputStream = seaRecordPo;
		
	}
}
