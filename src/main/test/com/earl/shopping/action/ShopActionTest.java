package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class ShopActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		// TODO Auto-generated method stub
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
	public void testUpdateCategory() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "3"); //
		request.addParameter("categorySimpleName", "东星白班鱼111");
		request.addParameter("categoryAcademicName", "东星白班鱼");
		request.addParameter("getType", "3");// 捕捞方式
		request.addParameter("categoryEnglishName", "东星白班鱼");
		request.addParameter("parentId", "1");
		request.addParameter("fishPhoto", "localhost:8080//aaa.jpg");
		request.addParameter("unit", "1");
		request.addParameter("totalSellNumber", "0");
//		request.addParameter("version", "3");
		String res = executeAction("/category_updateCategory.action");
		System.out.println(res);
	}

	@Test
	public void testGetAllCategory() throws UnsupportedEncodingException,
			ServletException {
		String res = executeAction("/category_getAllCategory.action");
		System.out.println(res);
	}

	@Test
	public void testGetNextLevelCategory() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "1"); // 鱼类
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "1");
		String res = executeAction("/category_getNextLevelCategory.action");

		System.out.println(res);
		assert res != null;
	}

	@Test
	public void testGetGoodsShops() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "2"); // 鱼类
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "2");
		String res = executeAction("/category_getGoodsShops.action");

		System.out.println(res);
		assert res != null;
	}

	@Test
	public void testGetHotCategory() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "2"); // 鱼类
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "2");
		String res = executeAction("/category_getHotCategory.action");

		System.out.println(res);
		assert res != null;
	}

}
