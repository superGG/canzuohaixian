package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.pojo.SkuPo;
import com.earl.fishshop.pojo.UnitPo;

/**
 * 
 * 单位action.只，斤，kg
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

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}


	// 下面填写业务逻辑

	public void addUnit() {
		Boolean save = unitServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 得到所有单位.
	 * @author 黄祥谦.
	 */
	public void getAllUnit(){
		List<UnitPo> unitList= unitServer.findAll();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("unitList", unitList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 得到指定单位下的规格.
	 * @author 黄祥谦.
	 */
	public void getSkuFromUnit(){
		List<SkuPo> skuList = unitServer.getSkuFromUnit(model.getUnitId());
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("skuList", skuList);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
	}
	
}
