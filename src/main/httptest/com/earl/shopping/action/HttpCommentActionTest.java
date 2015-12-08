package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpCommentActionTest extends HttpBaseActionTest{

	@Test
	public void testAddComment(){
		String targetURL = basePath + "comment_addComment.action";
		
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { 
				new StringPart("userId", "1","utf-8")
				,new StringPart("shopId", "1","utf-8")
				,new StringPart("commentType", "-1","utf-8")
				,new StringPart("content", "不错。我只是来测试而已","utf-8")
				,new StringPart("weightQuality", "3","UTF-8")
				,new StringPart("freshQuality", "2","utf-8")
				,new StringPart("speedQuality", "4","utf-8")
				,new StringPart("anonymity", "0","UTF-8")
				,new StringPart("ordersId", "11111122","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		
	}
	
	@Test
	public void testGetBedComment() {
		String targetURL = basePath + "comment_getBedComment.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetMidComment() {
		String targetURL = basePath + "comment_getMidComment.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetGoodComment() {
		String targetURL = basePath + "comment_getGoodComment.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetShopComment() {
		String targetURL = basePath + "comment_getShopComment.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
      
}