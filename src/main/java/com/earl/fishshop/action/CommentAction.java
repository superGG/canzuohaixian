package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.base.BaseAction;
import com.earl.fishshop.pojo.CommentPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 评论Action,评论商品. 
 * 
 * @author 黄祥谦.
 * 
 */
@Controller(value = "commentAction")
@Scope(value = "prototype")
public class CommentAction extends BaseAction<CommentPo> {

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
	 * 为商品添加评论.
	 * @author 黄祥谦.
	 */
	public void addComment() {
		Boolean save = commentServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
}
