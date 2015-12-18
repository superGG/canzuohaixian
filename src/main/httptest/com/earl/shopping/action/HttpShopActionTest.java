package com.earl.shopping.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpShopActionTest extends HttpBaseActionTest {

	@Test
	public void testGetShopCommentInfo() {
		String targetURL = basePath
				+ "shop_getShopCommentInfo.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
				new StringPart("shopId", "1", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetAllFarmersShop() {
		String targetURL = basePath
				+ "shop_getAllFarmersShop.action";

		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { 
//				new StringPart("shopId", "1", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetAllFishmanShop() {
		String targetURL = basePath
				+ "shop_getAllFishmanShop.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
//				new StringPart("shopId", "1", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	

}