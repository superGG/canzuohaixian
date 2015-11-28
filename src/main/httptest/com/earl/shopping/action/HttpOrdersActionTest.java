package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Ignore;
import org.junit.Test;

public class HttpOrdersActionTest extends BaseActionTest{

	@SuppressWarnings("unused")
	private File targetFile;

	private String bastPath = "http://192.168.1.107:8080";
//	private String bastPath = "http://www.earltech.cn:8080";
	
	@Ignore
	@Test
	public void testAddOrders(){
		String targetURL = bastPath+"/fishshop/orders_addOrders.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

		try {
			Part[] parts = {
			new StringPart("orders", "{" +
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
	public void testGetMyShopOrders(){
		String targetURL = bastPath + "/fishshop/orders_getMyShopOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("shopId", "4","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
		public void testGetAllUserOrders(){
			String targetURL = bastPath + "/fishshop/orders_getAllUserOrders.action";
			PostMethod filePost = new PostMethod(targetURL);
			
			Part[] parts = { 
					new StringPart("userId", "4","utf-8")
					,new StringPart("pageInfo.indexPageNum", "1","utf-8")
					,new StringPart("pageInfo.size", "3","UTF-8")
			};
			String sendHttpRequest = sendHttpRequest(filePost, parts);
			System.out.println(sendHttpRequest);
		}
	@Test
	public void testGetUnSentOrders(){
		String targetURL = bastPath + "/fishshop/orders_getUnSentOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("userId", "4","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetUnPayOrders(){
		String targetURL = bastPath + "/fishshop/orders_getUnPayOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("userId", "4","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetUngetOrders(){
		String targetURL = bastPath + "/fishshop/orders_getUngetOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("userId", "4","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetUnCommentOrders(){
		String targetURL = bastPath + "/fishshop/orders_getUnCommentOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("userId", "4","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetOrdersWithSeaRecord(){
		String targetURL = bastPath + "/fishshop/orders_getOrdersWithSeaRecord.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("seaRecordId", "6","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetPointOrders(){
		String targetURL = bastPath + "/fishshop/orders_getPointOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("ordersId", "11111123","utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}