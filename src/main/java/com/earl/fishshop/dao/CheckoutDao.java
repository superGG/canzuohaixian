package com.earl.fishshop.dao;

import com.earl.fishshop.pojo.CheckoutPo;

public interface CheckoutDao extends BaseDao<CheckoutPo>{

	/**
	 * 审查通过.
	 * @author 黄祥谦.
	 * @param checkoutId 审查的记录Id.
	 */
	void passRecord(Long checkoutId);

}
