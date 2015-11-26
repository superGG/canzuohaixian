package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpOrdersActionTest extends BaseActionTest{

	@SuppressWarnings("unused")
	private File targetFile;

	@Test
	public void testAddOrders(){
		String targetURL = "http://192.168.1.107:8080/fishshop/orders_addOrders.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getGoodsShops.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

		try {
			Part[] parts = { 
			new StringPart("orders", "{" +
					 "\"totalprice\" : \"30.5\"" +
					 ",\"userId\" : \"4\"" +
					 ",\"shopId\": \"1\"" +
					 ",\"buyerName\": \"yilinfeng\"" +
					 ",\"shopKeeperName\": \"海格号222\"" +
					 ",\"sendAddress\": \"广东省湛江市广东海洋大学22222\"" +
					 ",\"phone\": \"18719425973\"" +
					 ",\"version\": \"1\"" +
					 ",\"ordersDetail\": [{\"shopId\":\"5\"" +
					 						",\"goodsId\": \"1\"" +
					 						",\"categoryId\": \"8\"" +
					 						",\"goodsName\": \"sdfsd\"" +
					 						",\"price\": \"40.0\"" +
					 						",\"sku\": \"中等大小\"" +
					 						",\"unit\": \"斤\"" +
					 						",\"number\": \"5\"" +
					 						",\"version\": \"1\"" +
					 						",\"goodsType\":\"养殖\"}" +
					 					",{\"shopId\":\"5\"" +
					 						",\"goodsId\": \"1\"" +
					 						",\"categoryId\": \"7\"" +
					 						",\"goodsName\": \"sdfsd\"" +
					 						",\"price\": \"40.0\"" +
					 						",\"sku\": \"中等大小\"" +
				 							",\"unit\": \"斤\"" +
				 							",\"number\": \"5\"" +
				 							",\"version\": \"1\"" +
				 							",\"goodsType\":\"野生\"}" +
					 					",{\"shopId\":\"3\"" +
					 						",\"goodsId\": \"1\"" +
					 						",\"categoryId\": \"9\"" +
				 							",\"goodsName\": \"白星东邦鱼\"" +
				 							",\"price\": \"40.0\"" +
				 							",\"sku\": \"中等大小\"" +
				 							",\"unit\": \"斤\"" +
				 							",\"number\": \"5\"" +
				 							",\"version\": \"1\"" +
				 							",\"goodsType\":\"2343\"}" +
					 					"]" +
					 ",\"seaRecordId\": \"5\"" +
					 "}","utf-8")
			,new StringPart("getAddressId", "1","utf-8")
//			,new StringPart("pageInfo.size", "3","UTF-8")
			};
			sendHttpRequest(filePost, parts);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
	}
	@Test
	public void testGetNextLevelCategory(){
		String targetURL = "http://192.168.1.107:8080/fishshop/category_getNextLevelCategory.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getGoodsShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		
			Part[] parts = { 
					new StringPart("categoryId", "1","utf-8")
					,new StringPart("pageInfo.indexPageNum", "1","utf-8")
					,new StringPart("pageInfo.size", "3","UTF-8")
			};
			sendHttpRequest(filePost, parts);
	}
	
	@Test
	public void testGetAllUserOrders(){
		String targetURL = "http://192.168.1.107:8080/fishshop/orders_getAllUserOrders.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getGoodsShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("userId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		
		sendHttpRequest(filePost, parts);
		
	}

}