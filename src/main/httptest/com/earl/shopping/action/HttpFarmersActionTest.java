package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpFarmersActionTest extends HttpBaseActionTest {

	@Test
	public void testGetFarmerByShop() {
		String targetURL = basePath
				+ "farmers_getFarmerByShop.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("shopId", "5", "utf-8"),
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	

	@Test
	public void testGetFarmers() {
		String targetURL = basePath
				+ "farmers_getFarmers.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("farmersId", "2", "utf-8"),
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

}