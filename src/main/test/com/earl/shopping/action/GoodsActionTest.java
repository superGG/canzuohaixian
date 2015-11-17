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
	public void testAddGoods() throws Exception{
		 request.addParameter("shopId", "1");  
		 request.addParameter("categoryId", "2");  
		 request.addParameter("getType", "1");  
		 request.addParameter("price", "40");  
		 request.addParameter("nowNumber", "1000");  
		 request.addParameter("unit", "1");  
		 request.addParameter("sku", "1");  
		 request.addParameter("version", "1");  
	        String res=executeAction("/goods_addGoods.action");  
	        System.out.println(res); 
	}

	@Test
	public void testUpdateGoodPrice() throws UnsupportedEncodingException, ServletException {
		request.addParameter("goodsId", "1");
		request.addParameter("price", "34.5");
		String res=executeAction("/goods_updateGoodPrice.action");  
		System.out.println(res); 
	}
	
	@Test
	public void testUpdateGoodNowNumber() throws UnsupportedEncodingException, ServletException {
		request.addParameter("goodsId", "1");
		request.addParameter("nowNumber", "60");
		String res=executeAction("/goods_updateGoodNowNumber.action");  
		System.out.println(res); 
	}

	@Test
	public void testGetGoodsWithCategory() throws UnsupportedEncodingException, ServletException{
		request.addParameter("categoryId", "2");
		request.addParameter("shopId", "1");
		String res=executeAction("/goods_getGoodsWithCategory.action");  
		System.out.println(res); 
	}
	
	@Test
	public void testDeletePointCategoryGoods() throws UnsupportedEncodingException, ServletException{
		request.addParameter("categoryId", "2");
		request.addParameter("shopId", "1");
		String res=executeAction("/goods_deletePointCategoryGoods.action");  
		System.out.println(res); 
	}
	
	@Test
	public void testGetGoodsInfo() throws UnsupportedEncodingException, ServletException{
		request.addParameter("goodsId", "2");
		String res=executeAction("/goods_getGoodsInfo.action");  
		System.out.println(res); 
	}
}
