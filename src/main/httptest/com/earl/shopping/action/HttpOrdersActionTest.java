package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Assert;
import org.junit.Test;

import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.vo.ResultMessage;

public class HttpOrdersActionTest extends HttpBaseActionTest{

	@SuppressWarnings("unused")
	private File targetFile;

//	@Ignore
	@Test
	public void testAddOrders(){
		String targetURL = basePath+"orders_addOrders.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);
			Part[] parts = {
			new StringPart("orders", "{" +
					 "\"userId\" : \"4\"" +
					 ",\"shopId\": \"1\"" +
					 ",\"buyerName\": \"yilinfeng\"" +
					 ",\"shopKeeperName\": \"海格号\"" +
					 ",\"phone\": \"18719425973\"" +
					 ",\"ordersDetail\": [{\"goodsId\": \"1\"" +
					 						",\"number\": \"5\"}" +
					 					",{\"goodsId\": \"1\"" +
				 							",\"number\": \"5\"}" +
					 					",{\"goodsId\": \"1\"" +
				 							",\"number\": \"5\"}" +
					 					"]" +
					 ",\"seaRecordId\": \"5\"" +
					 "}","utf-8")
			,new StringPart("getAddressId", "23","utf-8")
//			,new StringPart("pageInfo.size", "3","UTF-8")
			};
			String sendHttpRequest = sendHttpRequest(filePost, parts);
			ResultMessage jsonToBean = JsonHelper.jsonToBean(sendHttpRequest, ResultMessage.class);
			Assert.assertTrue(jsonToBean.getServiceResult());
			System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetMyShopOrders(){
		String targetURL = basePath + "orders_getMyShopOrders.action";
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
			String targetURL = basePath + "orders_getAllUserOrders.action";
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
		String targetURL = basePath + "orders_getUnSentOrders.action";
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
	public void testGetShopUnSentOrders(){
		String targetURL = basePath + "orders_getShopUnSentOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("shopId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetUnPayOrders(){
		String targetURL = basePath + "orders_getUnPayOrders.action";
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
	public void testGetShopUnPayOrders(){
		String targetURL = basePath + "orders_getShopUnPayOrders.action";
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
	public void testGetUngetOrders(){
		String targetURL = basePath + "orders_getUngetOrders.action";
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
	public void testGetShopUngetOrders(){
		String targetURL = basePath + "orders_getShopUngetOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("shopId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetUnCommentOrders(){
		String targetURL = basePath + "orders_getUnCommentOrders.action";
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
	public void testGetShopUnCommentOrders(){
		String targetURL = basePath + "orders_getShopUnCommentOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("shopId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetOrdersWithSeaRecord(){
		String targetURL = basePath + "orders_getOrdersWithSeaRecord.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("shopId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetPointOrders(){
		String targetURL = basePath + "orders_getPointOrders.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = { 
				new StringPart("ordersId", "11111123","utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}