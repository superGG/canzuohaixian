package com.earl.fishshop.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.pojo.GetAddressPo;
import com.earl.fishshop.pojo.ResultMessage;

/**
 * 
 * 收货地址.
 * 
 * @author Administrator
 * 
 */
@Controller(value = "getAddressAction")
@Scope(value = "prototype")
public class GetAddressAction extends BaseAction<GetAddressPo> {

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
	 * 添加对象.
	 * @author 黄祥谦.
	 */
	public void addGetAddress() {
		Boolean save = getAddressServer.save(model);
		resultMessage = new ResultMessage();
		resultMessage.setResultInfo("添加成功");
		resultMessage.setServiceResult(save);
	}
	
	/**
	 * 更新收货人地址.
	 * @author 黄祥谦.
	 */
	public void updateGetAddress(){
		Boolean update = getAddressServer.update(model);
		resultMessage = new ResultMessage();
		resultMessage.setResultInfo("更新成功");
		resultMessage.setServiceResult(update);
	}
	
	/**
	 * 删除指定编号收货人地址.
	 * @author 黄祥谦.
	 */
	public void deleteGetAddress(){
		Boolean deleteById = getAddressServer.deleteById(model.getGetAddressId());
		resultMessage = new ResultMessage();
		resultMessage.setResultInfo("删除成功");
		resultMessage.setServiceResult(deleteById);
	}
	
	public void getUserAllAddress(){
		List<GetAddressPo> getAddress = getAddressServer.getUserAllAddress(model.getUserId());
	}
}
