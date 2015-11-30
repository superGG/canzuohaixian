package com.earl.fishshop.domain.getaddress;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;

public interface GetAddressService extends BaseService<GetAddressPo>{

	/**
	 * 得到指定用户的所有地址.
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	List<GetAddressPo> getUserAllAddress(Long userId);

	/**
	 * 添加收货地址
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addGetAddress(GetAddressPo model);

	/**
	 * 设置用户常用收货地址.
	 * @author 黄祥谦.
	 * @param getAddressId
	 * @param userId TODO
	 * @return
	 */
	Boolean updateUserAddress(Long getAddressId, Long userId);

	/**
	 * 删除用户收货地址.
	 * @author 黄祥谦.
	 * @param getAddressId
	 * @return
	 */
	Boolean deleteGetAddress(Long getAddressId);

	

	
	
	
}
