package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpFarmersActionTest extends BaseActionTest {

	private String bastPath = "http://192.168.1.111:8080/fishshop/";
//	 private String bastPath = "http://www.earltech.cn:8080";

	@Test
	public void testGetFarmerByShop() {
		String targetURL = bastPath
				+ "farmers_getFarmerByShop.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("shopId", "5", "utf-8"),
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

}