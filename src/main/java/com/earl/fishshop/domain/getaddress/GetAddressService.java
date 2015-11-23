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

	

	
	
	
}
