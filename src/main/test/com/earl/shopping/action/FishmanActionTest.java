package com.earl.shopping.action;

import java.io.File;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class FishmanActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("shopId","2");
		request.addParameter("getType", "3");// 捕捞方式
		request.addParameter("enginePower", "20");
		request.addParameter("homePort", "11");
		request.addParameter("realName", "王嘉涛");
		request.addParameter("tonnage", "20");
		request.addParameter("fishingLicense", "2000000");

		String res = executeAction("/fishman_addFishman.action");
		System.out.println(res);
	}

	@Test
	public void testGetFiahman() throws Exception {
		request.addParameter("fishmanId", "1"); 
		String res = executeAction("/fishman_getFiahman.action");

		System.out.println(res);
	}

	@Test
	public void testUpdateFishman() throws Exception {
		request.addParameter("fishmanId", "1"); 
		request.addParameter("getType", "2");// 捕捞方式
		request.addParameter("frontIdentityPhoto", "localhost:8081//bbb.jpg");
		request.addParameter("backIdentityPhoto", "localhost:8081//bbb.jpg");
		request.addParameter("seaPassPhoto", "localhost:8081//bbb.jpg");
		request.addParameter("shipPhoto", "localhost:8081//bbb.jpg");
		
		String res = executeAction("/fishman_updateFishman.action");
		System.out.println(res);
	}
	
	@Test
	public void testAuthenticationFishman() throws Exception {
		request.addParameter("userId", "1"); 
		request.addParameter("fishmanId", "1"); 
		File file = new File("D:/Favorites/test/QQ图片20150623221402.jpg");
		request.addHeader("fishmanFileVo", file);
		request.addHeader("fishmanFileVo", new File("D:/Favorites/test/test.jpg"));
		String res = executeAction("/fishman_authenticationFishman.action");

		System.out.println(res);
	}
	
	@Test
	public void testFindAllFiahmanNumber() throws Exception {
		
		String res = executeAction("/fishman_findAllFiahmanNumber.action");
		System.out.println(res);
	}
}
