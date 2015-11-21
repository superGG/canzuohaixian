package com.earl.fishshop.domain.searecord;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 航海记录Action.
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
		Boolean save = seaRecordServer.addSeaRecord(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	

}
