package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class GoodsActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		// TODO Auto-generated method stub
			String [] lala =	{"classpath*:applicationContext-*.xml"};  
			return lala;
	}
	
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testAddRandomUser() throws Exception{
		 request.addParameter("id", "1");  
	        String res=executeAction("/goods_lala.action");  
	        System.out.println(res); 
	}

	@Test
	public void testAddCustomUser() throws UnsupportedEncodingException, ServletException {

		request.addParameter("goods", "{\"goodsname\" : \"dodo\",\"description\": \"zhe ge shang ping\"}");
		
		String res=executeAction("/goods_returnGoods.action");  
		System.out.println(res); 
	}

}
