package com.earl.fishshop.domain.shipport;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 船靠岸口.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "shipPortAction")
@Scope(value = "prototype")
public class ShipPortAction extends BaseAction<ShipPortPo> {

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

	/**
	 * 添加对象.
	 * @author 黄祥谦.
	 */
	public void addShipPort() {
		Boolean save = shipPortServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 删除指定邮费.
	 * @author 黄祥谦.
	 */
	public void deletePointPostage(){
		Boolean success = shipPortServer.deleteById(model.getShipPortId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("删除成功");
		}else{
			resultMessage.setResultInfo("删除失败");
		}
		
	}
	
	public void findAllShipPort(){
			List<ShipPortPo> shipportList = shipPortServer.findAllShipPort();
			resultMessage = new ResultMessage();
			resultMessage.setServiceResult(true);
			resultMessage.getResultParm().put("shipportList",shipportList );
		
	}
}
