package com.earl.shopping.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class VerifyCodeActionTest extends StrutsSpringTestCase {

	
	
	
	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	
	
	@Test
	public void testAddVerifyCode() throws Exception {
		request.addParameter("phoneNumber", "18719425973");
		request.addParameter("verifyCode", "123456");
		
		String res = executeAction("/verifycode_addVerifyCode.action");
		System.out.println(res);
	}
	
	
	

}
