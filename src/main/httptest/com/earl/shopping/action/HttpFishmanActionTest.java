package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpFishmanActionTest extends HttpBaseActionTest {

	@Test
	public void testPassAuthenticationFishman() {
		String targetURL = basePath
				+ "fishman_passAuthenticationFishman.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("userId", "14", "utf-8"),
				new StringPart("fishmanId", "5", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

}