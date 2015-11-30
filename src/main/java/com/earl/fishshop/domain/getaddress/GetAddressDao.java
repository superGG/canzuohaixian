package com.earl.fishshop.domain.getaddress;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface GetAddressDao extends BaseDao<GetAddressPo>{

	/**
	 * 得到指定用户的所有收货地址.
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	List<GetAddressPo> getUserAllAddress(Long userId);

	/**
	 * 添加收货地址.
	 * @author 黄祥谦.
	 * @param model
	 */
	void addGetAddress(GetAddressPo model);

	/**
	 * 更新用户常用地址.
	 * @author 黄祥谦.
	 * @param getAddressId
	 * @param userId
	 */
	void updateUserAddress(Long getAddressId, Long userId);

	/**
	 * 得到第一条地址.
	 * @author 黄祥谦.
	 * @param userId
	 * @return
	 */
	GetAddressPo getFirst(Long userId);

}
