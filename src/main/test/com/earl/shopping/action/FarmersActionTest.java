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
	public void testGetFarmersByShop() throws Exception {
		request.addParameter("shopId", "5"); 
		String res = executeAction("/farmers_getFarmerByShop.action");

		System.out.println(res);
	}
}
