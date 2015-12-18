package com.earl.fishshop.domain.postage;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.domain.region.RegionPo;
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

	private static final long serialVersionUID = 3293435262298029608L;

	protected ResultMessage resultMessage;

	@ReturnValue //返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑
	
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
	
	/**
	 * 删除指定邮费.
	 * @author 黄祥谦.
	 */
	public void deletePointPostage(){
		Boolean success = postageServer.deleteById(model.getPostageId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if(success){
			resultMessage.setResultInfo("删除成功");
		}else{
			resultMessage.setResultInfo("删除失败");
		}
		
	}
	
	/**
	 * 更新邮费
	 * @author 黄祥谦.
	 */
	public void updatePostage(){
		Boolean update = postageServer.update(model);
		 resultMessage= new ResultMessage();
		 resultMessage.setServiceResult(update);
		 if(update){
			 resultMessage.setResultInfo("更新成功");
		 }else{
			 resultMessage.setResultInfo("更新失败");
		 }
	}
	
	/**
	 * 查询所有快递定价.
	 * @author 黄祥谦.
	 */
	public void findAllPostage(){
		List<PostagePo> postageList = postageServer.findAllPostage();
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("postageList", postageList);
	}
	
	/**
	 * 得到未设置邮费的地区
	 * @author 黄祥谦.
	 */
	public void getUnSetRegion(){
		List<RegionPo> regionList = postageServer.getUnSetRegion(Long.valueOf(model.getOrigin()));
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(true);
		resultMessage.getResultParm().put("regionList", regionList);
	}
	
}
