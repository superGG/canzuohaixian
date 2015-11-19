package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class UserActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testFindAllUser() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");
//
//		request.addParameter("categorySimpleName", "东星白班鱼");
//		request.addParameter("categoryAcademicName", "东星白班鱼");
//		request.addParameter("getType", "3");// 捕捞方式
//		request.addParameter("categoryEnglishName", "东星白班鱼");
//		request.addParameter("parentId", "");
//		request.addParameter("fishPhoto", "localhost:8080//aaa.jpg");
//		request.addParameter("unit", "1");
//		request.addParameter("totalSellNumber", "0");

		String res = executeAction("/user_findAllUser.action");
		System.out.println(res);
	}
	
	@Test
	public void testUserLogin() throws Exception {
		request.addParameter("userName", "易临风");
		request.addParameter("password", "798555920");
		
		String res = executeAction("/user_userLogin.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetAllFishmanUser() throws Exception {

		String res = executeAction("/user_getAllFishmanUser.action");
		System.out.println(res);
	}

	@Test
	public void testGetAllFarmersUser() throws Exception {

		String res = executeAction("/user_getAllFarmersUser.action");
		System.out.println(res);
	}
	

}
