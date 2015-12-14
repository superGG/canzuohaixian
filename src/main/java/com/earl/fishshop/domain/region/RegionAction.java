package com.earl.fishshop.domain.region;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 
 * @author 黄祥谦.
 * 
 */
@Controller(value = "regionAction")
@Scope(value = "prototype")
public class RegionAction extends BaseAction<RegionPo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	// 返回实体对象，或者其他任意对象
	@ReturnValue
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	public void addRegion(){
		regionServer.save(model);
	}
	
	public void updateRegion(){
		regionServer.update(model);
	}
}
