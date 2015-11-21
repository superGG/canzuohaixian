package com.earl.fishshop.domain.checkout;

import com.earl.fishshop.base.BaseDao;

public interface CheckoutDao extends BaseDao<CheckoutPo>{

	/**
	 * 审查通过.
	 * @author 黄祥谦.
	 * @param checkoutId 审查的记录Id.
	 */
	void passRecord(Long checkoutId);

	/**
	 * 审查不通过.
	 * @author 黄祥谦.
	 * @param checkoutId
	 */
	void nopassRecord(Long checkoutId);

}
