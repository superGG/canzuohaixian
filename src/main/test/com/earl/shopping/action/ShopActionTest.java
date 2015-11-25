package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class ShopActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	//如果是养殖户，需要发送养殖地点信息，经纬度过来
	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("shopName", "海格号");
		request.addParameter("userId", "1");
		request.addParameter("sendPrice", "40.5");
		request.addParameter("version", "1");

		String res = executeAction("/shop_addShop.action");
		System.out.println(res);
	}

	@Test
	public void testGetCategoryWithTotalNumber() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("shopId", "1"); //
		String res = executeAction("/shop_getCategoryWithTotalNumber.action");
		System.out.println(res);
	}

	@Test
	public void testGetShopAllGoods() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("shopId", "1");
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "3");
		String res = executeAction("/shop_getShopAllGoods.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetMyShop() throws UnsupportedEncodingException, ServletException{
		request.addParameter("shopId", "3");
		String res = executeAction("/shop_getMyShop.action");
		System.out.println(res);
		
	}
	
	@Test
	public void testGetShopCommentInfo() throws UnsupportedEncodingException, ServletException{
		request.addParameter("shopId", "3");
		String res = executeAction("/shop_getShopCommentInfo.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetAllFarmersShop() throws UnsupportedEncodingException, ServletException{
		String res = executeAction("/shop_getAllFarmersShop.action");
		System.out.println(res);
	}

}
