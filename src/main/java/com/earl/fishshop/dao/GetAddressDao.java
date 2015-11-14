package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.GetAddressPo;

public interface GetAddressDao extends BaseDao<GetAddressPo>{

	/**
	 * 得到指定用户的所有收货地址.
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	List<GetAddressPo> getUserAllAddress(Long userId);

}
