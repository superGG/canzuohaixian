package com.earl.fishshop.domain.gettype;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 捕捞类型Action.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "getTypeAction")
@Scope(value = "prototype")
public class GetTypeAction extends BaseAction<GetTypePo> {

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

	public void addGetType() {
		Boolean save = getTypeServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 得到带层次结构的捕捞方式，或者养殖方式.
	 * @author 黄祥谦.
	 */
	public void getHierarchyGetType(){
		List<GetTypePo> getTypeList = getTypeServer.getHierarchyGetType();
		resultMessage.getResultParm().put("getTypeList", getTypeList);
	}
	
	/**
	 * 得到顶层捕捞方式.
	 * @author 黄祥谦.
	 */
	public void getTopGetType(){
		List<GetTypePo> getTypeList = getTypeServer.getTopGetType();
		resultMessage.getResultParm().put("getTypeList", getTypeList);
	}
	
	/**
	 * 得到指定类别的下一级捕捞方式或者养殖方式.
	 * @author 黄祥谦.
	 */
	public void getNextLevelGetType(){
		List<GetTypePo> getTypeList = getTypeServer.getNextLevelGetType(model.getGetTypeId());
		resultMessage.getResultParm().put("getTypeList", getTypeList);
	}
	
	/**
	 * 得到养殖方式.
	 *@author 宋文光.
	 */
	public void getFarmerGetType() {
		model.setParentId(MyConstant.getType_farmer);
		List<GetTypePo> gettypelist = getTypeServer.getFarmerGetType(model);
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("list", gettypelist);
		resultMessage.setResultInfo("获取成功");
	}

	
}
