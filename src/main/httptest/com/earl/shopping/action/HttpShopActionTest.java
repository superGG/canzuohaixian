package com.earl.shopping.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpShopActionTest extends BaseActionTest {

	private String basePath = "http://192.168.1.111:8080"+"/fishshop/";
//	 private String basePath = "http://www.earltech.cn:8080"+"/fishshop/";

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
	public void testGetCategoryWithTotalNumber() {
		String targetURL = basePath + "shop_getCategoryWithTotalNumber.action";
		//----------------请求代码
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "2", "utf-8"),
				new StringPart("pageInfo.indexPageNum", "1", "utf-8"),
				new StringPart("pageInfo.size", "3", "UTF-8") };
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		//-----------------测试代码
		List<String> needCheckParam = new ArrayList<String>();
		needCheckParam.add("fishPhoto");
		needCheckParam.add("totalNowNumber");
		needCheckParam.add("categoryId");
		
		normalListAssert(sendHttpRequest, needCheckParam, "categoryList");
	}


}