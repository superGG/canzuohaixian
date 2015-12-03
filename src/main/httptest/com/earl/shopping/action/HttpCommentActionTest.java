package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpCommentActionTest extends BaseActionTest{

	String basePath = "http://192.168.1.111:8080/fishshop/";
	
	@Test
	public void testAddComment(){
//		String targetURL = "http://192.168.1.107:8080/fishshop/category_getNextLevelCategory.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getNextLevelCategory.action";
		String targetURL = basePath + "comment_addComment.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { 
				new StringPart("userId", "1","utf-8")
				,new StringPart("shopId", "1","utf-8")
				,new StringPart("ordersId", "11111110","UTF-8")
				,new StringPart("commentType", "-1","utf-8")
				,new StringPart("content", "不错。我只是来测试而已","utf-8")
				,new StringPart("weightQuality", "3","UTF-8")
				,new StringPart("freshQuality", "2","utf-8")
				,new StringPart("speedQuality", "4","utf-8")
				,new StringPart("anonymity", "1","UTF-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		
	}
      
}