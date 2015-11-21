package com.earl.shopping.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class VerifyActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
			String [] lala =	{"classpath*:applicationContext-*.xml"};  
			return lala;
	}
	
	@Test
	public void testGetVerifyCode() throws Exception{
	     String res=executeAction("/verify_getImgVerifyCode.action");  
	     System.out.println(res);
	}
	
	@Test
	public void testCheckSmsBao() throws Exception{
	     String res=executeAction("/verify_checkSmsBao.action");  
	     System.out.println(res);
	}
	
}
