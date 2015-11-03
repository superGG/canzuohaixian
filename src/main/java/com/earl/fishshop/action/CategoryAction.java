package com.earl.fishshop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 类别Action ,白星东斑鱼
 * @author 黄祥谦.
 * 
 */
@Controller(value = "categoryAction")
@Scope(value = "prototype")
public class CategoryAction extends BaseAction<CategoryPo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	protected CategoryPo model;
	
	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	/**
	 * 添加商品类别.
	 * @author 黄祥谦.
	 */
	public void addCategory() {
		Boolean save = categoryServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 查询所有商品类别.
	 * @author 黄祥谦.
	 */
	public void getAllCategory(){
		List<CategoryPo> categoryList = categoryServer.findAll();
		resultMessage = new ResultMessage();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("categoryList", categoryList);
		resultMessage.setResultParm(hashMap);
	}
	
	public void getCategoryHire(){
		List<CategoryPo> categoryList = categoryServer.getCategoryHire();
	}
	
}
