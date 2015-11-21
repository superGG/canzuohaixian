package com.earl.shopping.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class FarmersActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("shopId","1");
		request.addParameter("address","广东海洋大学");
		request.addParameter("frontIdentityPhoto", "localhost:8080//aaa.jpg");
		request.addParameter("backIdentityPhoto", "localhost:8080//aaa.jpg");
		request.addParameter("addressPhoto", "localhost:8080//aaa.jpg");

		String res = executeAction("/farmers_addFarmers.action");
		System.out.println(res);
	}

	@Test
	public void testGetFiahman() throws Exception {
		request.addParameter("fishmanId", "1"); 
		String res = executeAction("/fishman_getFiahman.action");

		System.out.println(res);
	}

}
