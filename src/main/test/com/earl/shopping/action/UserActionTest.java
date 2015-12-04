package com.earl.shopping.action;

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
		request.addParameter("phoneNumber", "18320489492");
		request.addParameter("password", "18320489492");
		
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
	
	
	@Test
	public void testSmsCodeOfRegister() throws Exception{
		 request.addParameter("phoneNumber", "18320489492");
	     String res=executeAction("/user_smsCodeOfRegister.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testSmsCodeOfFound() throws Exception{
		 request.addParameter("phoneNumber", "18320489592");
	     String res=executeAction("/user_smsCodeOfFound.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testConfirmSmsVerifyCode() throws Exception{
		 request.addParameter("phoneNumber", "18320489492");
		 request.addParameter("verifyCode", "656363");
		 
	     String res=executeAction("/user_confirmSmsVerifyCode.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testAddUser() throws Exception{
		 request.addParameter("phoneNumber", "18320489492");
		 request.addParameter("password", "18320489492");
		 request.addParameter("verifyCode", "123456");
		 
	     String res=executeAction("/user_addUser.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testCheckSmsBao() throws Exception{
	     String res=executeAction("/user_checkSmsBao.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testBlackUser() throws Exception{
		 request.addParameter("identityId", "2");
		 request.addParameter("userType", "1");
	     String res=executeAction("/user_blackUser.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testGetVerifyFishman() throws Exception{
	     String res=executeAction("/user_getVerifyFishman.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testGetVerifyFarmers() throws Exception{
	     String res=executeAction("/user_getVerifyFarmers.action");  
	     System.out.println(res);
	}

}
