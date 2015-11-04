package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.ResultMessage;
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

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}


	// 下面填写业务逻辑

	public void addSeaRecord() {
		Boolean save = seaRecordServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
		
	}
}
