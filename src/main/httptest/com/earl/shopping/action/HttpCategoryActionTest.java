package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpCategoryActionTest extends BaseActionTest {

	@SuppressWarnings("unused")
	private File targetFile;

	String basePath = "http://www.earltech.cn:8080";
//	String basePath = "http://192.168.1.107:8080";
	// String targetURL =
	// "http://192.168.1.107:8080/fishshop/category_getGoodsShops.action";
	String targetURL = basePath + "/fishshop/category_getGoodsShops.action";

	@Test
	public void testGetCategoryWithSku() {
		String targetURL = basePath
				+ "/fishshop/category_getCategoryWithSku.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetTopCategory() {
		String targetURL = basePath
				+ "/fishshop/category_getTopCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = {};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetAllNextLevelCategory() {
		String targetURL = basePath
				+ "/fishshop/category_getAllNextLevelCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetNextLevelCategory() {
		String targetURL = basePath
				+ "/fishshop/category_getNextLevelCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);

	}

	@Test
	public void testGetHotCategory() {
		String targetURL = basePath
				+ "/fishshop/category_getHotCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetGoodsShops() {
		String targetURL = basePath + "/fishshop/category_getGoodsShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	@Test
	public void testGetGoodsFishShops() {
		String targetURL = basePath + "/fishshop/category_getGoodsFishShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetGoodsFarmerShops() {
		String targetURL = basePath + "/fishshop/category_getGoodsFarmerShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}