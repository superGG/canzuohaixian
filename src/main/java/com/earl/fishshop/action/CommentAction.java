package com.earl.fishshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CommentPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
@Controller(value = "commentAction")
@Scope(value = "prototype")
public class CommentAction extends BaseAction<CommentPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected CommentPo jsonInputStream;
	
	protected CommentPo model;

	@ReturnValue //返回实体对象，或者其他任意对象
	public CommentPo getJsonInputStream() {
		return jsonInputStream;
	}

	// 下面填写业务逻辑

	/**
	 * 为商品添加评论.
	 * @author 黄祥谦.
	 */
	public void addComment() {
		commentServer.save(model);
		CommentPo commentPo = new CommentPo();
		jsonInputStream = commentPo;
	}
}
