package com.earl.fishshop.service;

import java.util.List;

import com.earl.fishshop.pojo.GetAddressPo;

public interface GetAddressService extends BaseService<GetAddressPo>{

	/**
	 * 得到指定用户的所有地址.
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	List<GetAddressPo> getUserAllAddress(Long userId);

	

	
	
	
}
