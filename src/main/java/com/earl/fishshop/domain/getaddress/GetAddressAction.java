package com.earl.fishshop.domain.getaddress;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.annotation.ReturnValue;
import com.earl.fishshop.domain.base.BaseAction;
import com.earl.fishshop.domain.user.UserPo;
import com.earl.fishshop.vo.ResultMessage;

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

	@ReturnValue
	// 返回实体对象，或者其他任意对象
	public ResultMessage getResultMessage() {
		return resultMessage;
	}

	// 下面填写业务逻辑

	/**
	 * 添加对象.
	 * 
	 * @author 黄祥谦.
	 */
	public void addGetAddress() {
		Boolean save = getAddressServer.addGetAddress(model);
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(save);
		if (save) {
			resultMessage.setResultInfo("添加成功");
		} else {
			resultMessage.setResultInfo("添加失败");
		}
	}

	/**
	 * 删除指定编号收货人地址.
	 * 
	 * @author 黄祥谦.
	 */
	public void deleteGetAddress() {
		Boolean deleteById = getAddressServer.deleteGetAddress(model
				.getGetAddressId());
		resultMessage = new ResultMessage();
		resultMessage.setResultInfo("删除成功");
		resultMessage.setServiceResult(deleteById);
	}

	/**
	 * 动态更新. 更新收货人地址.
	 * 
	 * @author 黄祥谦.
	 */
	public void updateGetAddress() {
		Boolean update = getAddressServer.updateWithNotNullProperties(model);
		resultMessage = new ResultMessage();
		resultMessage.setResultInfo("更新成功");
		resultMessage.setServiceResult(update);
	}

	/**
	 * 设置用户常用地址.
	 * 
	 * @author 黄祥谦.
	 */
	public void updateUserAddress() {
		Boolean success = getAddressServer.updateUserAddress(
				model.getGetAddressId(), model.getUserId());
		resultMessage = new ResultMessage();
		resultMessage.setServiceResult(success);
		if (success) {
			resultMessage.setResultInfo("更新成功");
		} else {
			resultMessage.setResultInfo("更新失败");
		}
	}

	/**
	 * 得到用户的所有收货地址.
	 * 
	 * @author 黄祥谦.
	 */
	public void getUserAllAddress() {
		List<GetAddressPo> getAddressList = getAddressServer
				.getUserAllAddress(model.getUserId());
		UserPo userPo = userServer.get(model.getUserId());
		resultMessage = new ResultMessage();
		resultMessage.getResultParm().put("getAddressList", getAddressList);
		resultMessage.getResultParm().put("default", userPo.getGetAddressId());
		resultMessage.setResultInfo("访问成功");
		resultMessage.setServiceResult(true);
	}

	/**
	 * 得到用户默认地址.
	 * 
	 * @author 黄祥谦.
	 */
	public void getDefaultAddress() {
		UserPo userPo = userServer.get(model.getUserId());
		resultMessage = new ResultMessage();
		if(userPo.getGetAddressId() != null){
			GetAddressPo getAddressPo = getAddressServer.get(userPo
					.getGetAddressId());
			resultMessage.getResultParm().put("getAddress", getAddressPo);
			resultMessage.setResultInfo("访问成功");
			resultMessage.setServiceResult(true);
		}else{
//			throw new RuntimeException("故意失败，给ErroInterceptor处理");
			resultMessage.setResultInfo("没有默认地址");
			resultMessage.setServiceResult(false);
		}
	}
}
