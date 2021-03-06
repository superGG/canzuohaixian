package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class CategoryActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("categorySimpleName", "东星白班鱼");
		request.addParameter("categoryAcademicName", "东星白班鱼");
		request.addParameter("getType", "3");// 捕捞方式
		request.addParameter("categoryEnglishName", "东星白班鱼");
		request.addParameter("parentId", "");
		request.addParameter("fishPhoto", "localhost:8080//aaa.jpg");
		request.addParameter("unit", "1");
		request.addParameter("totalSellNumber", "0");

		String res = executeAction("/category_addCategory.action");
		System.out.println(res);
	}

	@Test
	public void testDeleteCategory() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "2"); // 鱼类
		String res = executeAction("/category_deleteCategory.action");
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
//		request.addParameter("version", "3");
		String res = executeAction("/category_updateCategory.action");
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
	public void testGoodsFarmerShops() throws UnsupportedEncodingException, ServletException{
		request.addParameter("categoryId", "2"); // 鱼类
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "2");
		String res = executeAction("/category_getGoodsFarmerShops.action");
		
		System.out.println(res);
		
	}
	
	@Test
	public void testGetHotCategory() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "2"); // 
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "2");
		String res = executeAction("/category_getHotCategory.action");

		System.out.println(res);
		assert res != null;
	}
	

	@Test
	public void testGetGoodsShops1() throws UnsupportedEncodingException,
			ServletException {
		request.addParameter("categoryId", "2"); // 鱼类
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "2");
		request.addParameter("sortType", "3");
		String res = executeAction("/category_getGoodsShops1.action");

		System.out.println(res);
		assert res != null;
	}

}
