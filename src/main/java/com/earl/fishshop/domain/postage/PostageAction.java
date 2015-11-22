package com.earl.fishshop.domain.postage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
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
	
}
