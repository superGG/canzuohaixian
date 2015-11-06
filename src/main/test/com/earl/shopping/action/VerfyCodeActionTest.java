package com.earl.shopping.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class VerfyCodeActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		// TODO Auto-generated method stub
			String [] lala =	{"classpath*:applicationContext-*.xml"};  
			return lala;
	}
	
	@Test
	public void testGetVerifyCode() throws Exception{
	     String res=executeAction("/verfycode_getVerifyCode.action");  
	     System.out.println(res);
	}
	
	
}
