package com.earl.shopping.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpCategoryActionTest extends HttpBaseActionTest {

	private File targetFile;

	@Test
	public void testGetCategoryWithSku() {
		String targetURL = basePath
				+ "category_getCategoryWithSku.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "8", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		//----------测试
		List<String> needCheckParam = new ArrayList<String>();
		needCheckParam.add("skuArrayList");
		normalObjectAssert(sendHttpRequest, needCheckParam, "category");
	}
	
	@Test
	public void testAddGoods() throws Exception{
		String targetURL = basePath
				+ "category_addGoods.action";
		targetFile = new File("C:\\Users\\Administrator\\Desktop\\SpringMVC.jpg.png");
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = {
		new FilePart("categoryFile.file", targetFile)
		,new StringPart("category", "{\"categoryId\":1,\"shopId\":1,\"fishPhoto\":\"category/aaa.jpg\",\"skuArrayList\":[{\"skuId\":1,\"price\":34.5},{\"skuId\":2,\"price\":35.5}]}", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		//----------测试
//		List<String> needCheckParam = new ArrayList<String>();
//		needCheckParam.add("skuArrayList");
//		normalObjectAssert(sendHttpRequest, needCheckParam, "category");
	}

	@Test
	public void testGetTopCategory() {
		String targetURL = basePath
				+ "category_getTopCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = {};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetAllNextLevelCategory() {
		String targetURL = basePath
				+ "category_getAllNextLevelCategory.action";
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
				+ "category_getNextLevelCategory.action";
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
				+ "category_getHotCategory.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "1", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}

	@Test
	public void testGetGoodsShops() {
		String targetURL = basePath + "category_getGoodsShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	@Test
	public void testGetGoodsFishShops() {
		String targetURL = basePath + "category_getGoodsFishShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
	
	@Test
	public void testGetGoodsFarmerShops() {
		String targetURL = basePath + "category_getGoodsFarmerShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("categoryId", "7", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}