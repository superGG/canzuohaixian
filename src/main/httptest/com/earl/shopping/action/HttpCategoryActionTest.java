package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpCategoryActionTest extends BaseActionTest{

	@SuppressWarnings("unused")
	private File targetFile;

	@Test
	public void testGetGoodsShops(){
		String targetURL = "http://192.168.1.107:8080/fishshop/category_getGoodsShops.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getGoodsShops.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

			Part[] parts = { 
			new StringPart("categoryId", "7","utf-8")
			,new StringPart("pageInfo.indexPageNum", "1","utf-8")
			,new StringPart("pageInfo.size", "3","UTF-8")
			// new FilePart(targetFile.getName(), targetFile)
			};
			sendHttpRequest(filePost, parts);
	}
	@Test
	public void testGetNextLevelCategory(){
		String targetURL = "http://192.168.1.107:8080/fishshop/category_getNextLevelCategory.action";
//		String targetURL = "http://www.earltech.cn:8080/fishshop/category_getGoodsShops.action";
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { 
				new StringPart("categoryId", "1","utf-8")
				,new StringPart("pageInfo.indexPageNum", "1","utf-8")
				,new StringPart("pageInfo.size", "3","UTF-8")
		};
		sendHttpRequest(filePost, parts);
		
	}
}