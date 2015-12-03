package com.earl.shopping.action;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpGetAddressActionTest extends BaseActionTest {

	private String bastPath = "http://192.168.1.111:8080/fishshop/";
//	 private String bastPath = "http://www.earltech.cn:8080";

	@Test
	public void testAddGetAddress() {
		String targetURL = bastPath
				+ "getaddress_addGetAddress.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("userId", "4", "utf-8"),
				new StringPart("userName", "易临风", "utf-8"),
				new StringPart("address", "广东省湛江市麻章区广东海洋大学", "utf-8"),
				new StringPart("phone", "18719425973", "utf-8"),
				new StringPart("postcode", "524000", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testUpdateGetAddress() {
		String targetURL = bastPath
				+ "getaddress_updateGetAddress.action";
		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("userId", "4", "utf-8"),
				new StringPart("getAddressId", "17", "utf-8"),
				new StringPart("userName", "易临风", "utf-8"),
				new StringPart("address", "广东省湛江市麻章区广东海洋大学222", "utf-8"),
				new StringPart("phone", "187194259732", "utf-8"),
				new StringPart("postcode", "5240002", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testDeleteGetAddress() {
		String targetURL = bastPath
				+ "getaddress_deleteGetAddress.action";
		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("getAddressId", "16", "utf-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testUpdateUserAddress() {
		String targetURL = bastPath
				+ "getaddress_updateUserAddress.action";
		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { new StringPart("userId", "4", "utf-8"),
				new StringPart("getAddressId", "5", "utf-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	@Test
	public void testGetUserAllAddress() {
		String targetURL = bastPath
				+ "getaddress_getUserAllAddress.action";
		PostMethod filePost = new PostMethod(targetURL);
		
		Part[] parts = {
				new StringPart("userId", "4", "utf-8"),
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}