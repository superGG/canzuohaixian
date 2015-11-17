package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.earl.fishshop.util.MyConstant;

public class OrdersActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		// TODO Auto-generated method stub
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");
		
		// 使用下面方式，不能直接用struts的modeldriven
		 request.addParameter("orders", "{" +
		 "\"totalprice\" : \"30.5\"" +
		 ",\"userId\" : \"1\"" +
		 ",\"shopId\": \"1\"" +
		 ",\"state\": \"1\"" +
		 ",\"buyerName\": \"yilinfeng\"" +
		 ",\"shopKeeperName\": \"海格号222\"" +
		 ",\"sendAddress\": \"广东省湛江市广东海洋大学\"" +
		 ",\"phone\": \"18719425973\"" +
		 ",\"version\": \"1\"" +
		 ",\"ordersDetail\": [{\"shopId\":\"5\"" +
		 						",\"goodsId\": \"1\"" +
		 						",\"categoryId\": \"5\"" +
		 						",\"goodsName\": \"sdfsd\"" +
		 						",\"price\": \"40.0\"" +
		 						",\"sku\": \"中等大小\"" +
		 						",\"unit\": \"斤\"" +
		 						",\"number\": \"5\"" +
		 						",\"version\": \"1\"" +
		 						",\"goodsType\":\"养殖\"}" +
		 					",{\"shopId\":\"5\"" +
		 						",\"goodsId\": \"1\"" +
		 						",\"categoryId\": \"5\"" +
		 						",\"goodsName\": \"sdfsd\"" +
		 						",\"price\": \"40.0\"" +
		 						",\"sku\": \"中等大小\"" +
	 							",\"unit\": \"斤\"" +
	 							",\"number\": \"5\"" +
	 							",\"version\": \"1\"" +
	 							",\"goodsType\":\"野生\"}" +
		 					",{\"shopId\":\"3\"" +
		 						",\"goodsId\": \"1\"" +
		 						",\"categoryId\": \"5\"" +
	 							",\"goodsName\": \"sdfsd\"" +
	 							",\"price\": \"40.0\"" +
	 							",\"sku\": \"中等大小\"" +
	 							",\"unit\": \"斤\"" +
	 							",\"number\": \"5\"" +
	 							",\"version\": \"1\"" +
	 							",\"goodsType\":\"2343\"}" +
		 					"]" +
		 ",\"seaRecordId\": \"5\"" +
		 "}");
//		 {"ordersId":2,"buyerName":"dsdf","ordersDetail":[{"categoryId":1,"goodsType":"2343"},{"categoryId":1,"goodsType":"2343"}],"orderNumber":"134345","version":0}
		String res = executeAction("/orders_addOrders.action");
		System.out.println(res);
	}

	@Test
	public void testUpdateOrdersState() throws UnsupportedEncodingException, ServletException{
		request.addParameter("state", ""+MyConstant.order_unget);
		request.addParameter("ordersId", "3");
		String res = executeAction("/orders_updateOrders.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetMyShopOrders() throws UnsupportedEncodingException, ServletException{
		request.addParameter("shopId", "1");
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "3");
		String res = executeAction("/orders_getMyShopOrders.action");
		System.out.println(res);
	}
	
	@Test
	public void testDeleteOrders() throws UnsupportedEncodingException, ServletException{
		request.addParameter("ordersId", "3");
		String res = executeAction("/orders_deleteOrders.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetOrdersWithSeaRecord() throws UnsupportedEncodingException, ServletException{
		request.addParameter("seaRecordId", "5");
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "3");
		String res = executeAction("/orders_getOrdersWithSeaRecord.action");
		System.out.println(res);
	}
	
	@Test
	public void testSetOrderNumber() throws UnsupportedEncodingException, ServletException{
		request.addParameter("ordersId", "1");
		request.addParameter("orderNumber", "2349729347");
		String res = executeAction("/orders_setOrderNumber.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetUnSentOrders() throws UnsupportedEncodingException, ServletException{
		request.addParameter("userId", "1");
		request.addParameter("pageInfo.indexPageNum", "1");
		request.addParameter("pageInfo.size", "3");
		String res = executeAction("/orders_getUnPayOrders.action");
		System.out.println(res);
	}
	
}
