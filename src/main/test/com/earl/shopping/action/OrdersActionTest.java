package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.earl.fishshop.pojo.OrdersDetailPo;

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
		
//		request.addParameter("ordersDetail.shopId", "5");request.addParameter("ordersDetail.goodsId", "5");request.addParameter("ordersDetail.order1.categoryId", "5");request.addParameter("ordersDetail.goodsName", "sdfs");request.addParameter("ordersDetail.goodsType", "dsfs");request.addParameter("ordersDetail.price", "40.0");request.addParameter("ordersDetail.sku", "sdf");request.addParameter("ordersDetail.unit", "sdf");request.addParameter("ordersDetail.number", "5");request.addParameter("ordersDetail.isDelete", "false");request.addParameter("ordersDetail.version", "1");
//		
//		request.addParameter("ordersDetail.shopId", "6");request.addParameter("ordersDetail.goodsId", "5");request.addParameter("ordersDetail.categoryId", "5");request.addParameter("ordersDetail.goodsName", "sdfs");request.addParameter("ordersDetail.goodsType", "dsfs");request.addParameter("ordersDetail.price", "40.0");request.addParameter("ordersDetail.sku", "sdfs");request.addParameter("ordersDetail.unit", "sdf");request.addParameter("ordersDetail.number", "5");request.addParameter("ordersDetail.isDelete", "false");request.addParameter("ordersDetail.version", "1");
		
//		request.addParameter("totalprice", "30.5");request.addParameter("state", "1");request.addParameter("buyerName", "yilinfeng");request.addParameter("seaRecordId", "5");request.addParameter("isDelete", "false");request.addParameter("version", "1");
		// 使用下面方式，不能直接用struts的modeldriven
		 request.addParameter("orders", "{" +
		 "\"totalprice\" : \"30.5\"" +
		 ",\"state\": \"1\"" +
		 ",\"buyerName\": \"yilinfeng\"" +
		 ",\"seaRecordId\": \"5\"" +
		 ",\"version\": \"1\"" +
		 ",\"ordersDetail\": [{\"shopId\":\"5\"" +
		 						",\"goodsId\": \"5\"" +
		 						",\"categoryId\": \"5\"" +
		 						",\"goodsName\": \"sdfsd\"" +
		 						",\"price\": \"40.0\"" +
		 						",\"sku\": \"中等大小\"" +
		 						",\"unit\": \"斤\"" +
		 						",\"number\": \"5\"" +
		 						",\"version\": \"1\"" +
		 						",\"goodsType\":\"2341\"}" +
		 					",{\"shopId\":\"5\"" +
		 						",\"goodsId\": \"5\"" +
		 						",\"categoryId\": \"5\"" +
		 						",\"goodsName\": \"sdfsd\"" +
		 						",\"price\": \"40.0\"" +
		 						",\"sku\": \"中等大小\"" +
	 							",\"unit\": \"斤\"" +
	 							",\"number\": \"5\"" +
	 							",\"version\": \"1\"" +
	 							",\"goodsType\":\"2342\"}" +
		 					",{\"shopId\":\"3\"" +
		 						",\"goodsId\": \"5\"" +
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

}
