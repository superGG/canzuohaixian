package com.earl.fishshop.domain.postage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.vo.ResultMessage;

/**
 * 
 * 单位action.只，斤，kg
 * @author Administrator
 * 
 */
@Controller(value = "postageAction")
@Scope(value = "prototype")
public class PostageAction extends BaseAction<PostagePo> {

	Long [] destinationList;
	
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑
	
	public Long[] getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(Long[] destinationList) {
		this.destinationList = destinationList;
	}

	/**
	 * 添加
	 * @author 黄祥谦.
	 */
	public void addPostage(){
		Boolean success = postageServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("添加成功");
		}else{
			resultMessage.setResultInfo("添加失败");
		}
	}
	
}
