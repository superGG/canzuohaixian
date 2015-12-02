package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpShopActionTest extends BaseActionTest {

//	private String bastPath = "http://192.168.1.107:8080";
	 private String bastPath = "http://www.earltech.cn:8080";

	@Test
	public void testGetShopCommentInfo() {
		String targetURL = bastPath
				+ "/fishshop/shop_getShopCommentInfo.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
				new StringPart("shopId", "1", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}