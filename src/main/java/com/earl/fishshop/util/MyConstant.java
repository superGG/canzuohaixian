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
	 * 用户被拉黑 v3.(state)
	 */
	public static final Integer user_black= 5;
	
	/**
	 * 等待审查 v2.(state)
	 */
	public static final Integer user_wait = 2;
	
	/**
	 * 用户认证通过 v1.(state)
	 */
	public static final Integer user_pass = 1;

	/**
	 * 用户认证无法通过 v3.(state)
	 */
	public static final Integer user_nopass = 3;
	
	/**
	 * 普通用户代号 v0.(userType)
	 */
	public static final Integer user_normal = 0;
	
	/**
	 * 渔户用户代号 v1.(userType)
	 */
	public static final Integer user_fishman= 1;
	
	/**
	 * 养殖户用户代号 v2.(userType)
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
	 * 订单已经评论 v4.
	 */
	public static final Integer order_comment = 4;
	
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
	 * 好评.(connentType)
	 */
	public static final Integer comment_good = 1;
	
	/**
	 * 中评(connentType)
	 */
	public static final Integer comment_med = 0;
	
	/**
	 * 差评.(connentType)
	 */
	public static final Integer comment_bed = -1;
	
	/**
	 * 评论匿名.(anonymity)
	 */
	public static final Integer comment_anonymity = 1;

	/**
	 * 养殖类的类别
	 */
	public static final Integer category_breed = 0;
	/**
	 * 野生类的类别
	 */
	public static final Integer category_wild = 1;
	
	/**
	 * 正在出航.
	 */
	public static final Integer searecord_seaing = 0;
	
	/**
	 * 延迟出航.
	 */
	public static final Integer searecord_delay = 1;
	
	/**
	 * 准时到岸.
	 */
	public static final Integer searecord_ontime = 2;
	
	/**
	 * 提前到港.
	 */
	public static final Integer searecord_ahead = 3;
	
	/**
	 * 综合排序1.
	 */
	public static final Integer sort_synthesize = 1;
	
	/**
	 * 评价排序2.
	 */
	public static final Integer sort_comment = 2;
	
	/**
	 * 起送价排序3.
	 */
	public static final Integer sort_sendPrice = 3;
	
	/**
	 * 销量排序4.
	 */
	public static final Integer sort_sellNumber = 4;
}
