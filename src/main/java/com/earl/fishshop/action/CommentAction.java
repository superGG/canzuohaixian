package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CommentPo;
import com.earl.fishshop.pojo.ResultMessage;
import com.earl.fishshop.vo.PageInfo;

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

	/**
	 * 分页信息.
	 */
	private PageInfo pageInfo;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	/**
	 * 为商店添加评论.
	 * @author 黄祥谦.
	 */
	public void addComment() {
		Boolean save = commentServer.save(model);
		shopServer.updateShopComment(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	

	/**
	 * 获取商店的所有评论.
	 * @author 宋文光.
	 */
	public void getShopComment() {
		List<CommentPo> list = commentServer.getShopComment(model.getShopId(), pageInfo);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("comment", list);
		resultMessage.setResultParm(hashMap);
		resultMessage.setServiceResult(true);
		
	}
	

	/**
	 * 获取商店所有好评.
	 * @author 宋文光.
	 */
	public void getGoodComment() {
		List<CommentPo> list = commentServer.getGoodComment(model.getShopId(), pageInfo);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("goodComment", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(map);
		resultMessage.setServiceResult(true);
	}

	/**
	 * 获取商店所有中评.
	 * @author 宋文光.
	 */
	public void getMidComment() {
		List<CommentPo> list = commentServer.getMidComment(model.getShopId(), pageInfo);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("midComment", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(map);
		resultMessage.setServiceResult(true);
	}
	
	/**
	 * 获取商店所有差评.
	 * @author 宋文光.
	 */
	public void getBedComment() {
		List<CommentPo> list = commentServer.getBedComment(model.getShopId(), pageInfo);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bedComment", list);
		resultMessage = new ResultMessage();
		resultMessage.setResultParm(map);
		resultMessage.setServiceResult(true);
	}
}
