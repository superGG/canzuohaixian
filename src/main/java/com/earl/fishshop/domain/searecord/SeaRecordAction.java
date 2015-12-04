package com.earl.fishshop.domain.searecord;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
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
		if(save){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
	}
	
	/**
	 * 提前到港.
	 * @author 黄祥谦.
	 */
	public void aheadEndSeaing(){
		Boolean success = seaRecordServer.aheadEndSeaing(model.getShopId(),model.getEndSeeTime());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
		
		
	}

	/**
	 * 商家延迟到港.
	 * @author 黄祥谦.
	 */
	public void delayEndSeaing(){
		Boolean success = seaRecordServer.delayEndSeaing(model.getShopId(), model.getEndSeeTime());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
	}
	
	/**
	 * 商家是否已经到港.
	 * @author 黄祥谦.
	 */
	public void booleanEndSeaing(){
		Boolean success = seaRecordServer.booleanEndSeaing(model.getShopId());
		resultMessage = new ResultMessage();
		HashMap<String, Object> resultParm = new HashMap<String, Object>();
		resultParm.put("booleanEnd", success);
		resultMessage.setResultParm(resultParm);
		resultMessage.setServiceResult(true);
		resultMessage.setResultInfo("操作成功");
	}
	
	/**
	 * 到港口了，停止出港
	 * 
	 * @author 黄祥谦.
	 */
	public void endSeaing() {
		Boolean success = shopServer.endSeaing(model.getShopId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("操作成功");
		}else{
			resultMessage.setResultInfo("操作失败");
		}
	}
}
