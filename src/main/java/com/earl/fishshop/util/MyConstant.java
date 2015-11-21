package com.earl.fishshop.util;
/**
 * @author 黄祥谦.
 * @date:2015-11-4 下午4:34:38
 * @version :
 */
public class MyConstant {

	/**
	 * 审查不通过 v0.
	 */
	public static final Integer checkout_nopass = 0;

	/**
	 * 等待审查 v2.
	 */
	public static final Integer checkout_waitpass = 2;
	/**
	 * 审查通过 v1.
	 */
	public static final Integer checkout_pass = 1;
	
	/**
	 * 用户被拉黑 v3.
	 */
	public static final Integer user_black= 3;
	
	/**
	 * 等待审查 v2.
	 */
	public static final Integer user_wait = 2;
	
	/**
	 * 用户认证通过 v1.
	 */
	public static final Integer user_pass = 1;

	/**
	 * 用户认证无法通过 v0.
	 */
	public static final Integer user_nopass = 0;
	
	/**
	 * 普通用户代号 v0.
	 */
	public static final Integer user_normal = 0;
	
	/**
	 * 渔户用户代号 v1.
	 */
	public static final Integer user_fishman= 1;
	
	/**
	 * 养殖户用户代号 v2.
	 */
	public static final Integer user_farmer= 2;

	/**
	 * 订单未发货 v0.
	 */
	public static final Integer order_unsent = 0;
	
	/**
	 * 订单未支付 v1.
	 */
	public static final Integer order_unpay= 1;

	/**
	 * 订单未收货 v2.
	 */
	public static final Integer order_unget = 2;

	/**
	 * 订单未评论 v3.
	 */
	public static final Integer order_uncomment = 3;
	
	/**
	 * 订单完成支付状态.
	 */
	public static final Integer order_pay = 4;

	public static final Boolean shop_notOnSell = false;
	
	public static final Boolean shop_onSell = true;

	/**
	 * 标志渔户商店 v0
	 */
	public static final Integer shop_fishman = 0;

	/**
	 * 标志养殖户商店 v1
	 */
	public static final Integer shop_farmerman = 1;
	
	/**
	 * 好评.
	 */
	public static final Integer comment_good = 1;
	
	/**
	 * 中评
	 */
	public static final Integer comment_med = 0;
	
	/**
	 * 差评.
	 */
	public static final Integer comment_bed = -1;


	
	

}
