package com.earl.fishshop.service;

import com.earl.fishshop.pojo.CheckoutPo;

public interface CheckoutService extends BaseService<CheckoutPo>{

	/**
	 * 审查通过.
	 * @author 黄祥谦.
	 * @param checkoutId TODO
	 * @return
	 */
	Boolean passRecord(Long checkoutId);

	/**
	 * 审查不通过.
	 * @author 黄祥谦.
	 * @param checkoutId
	 * @return
	 */
	Boolean nopassRecord(Long checkoutId);

	

	
	
	
}
