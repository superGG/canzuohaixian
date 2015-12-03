package com.earl.shopping.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class HttpGoodsActionTest extends BaseActionTest {

	private String basePath = "http://192.168.1.111:8080"+"/fishshop/";
//	 private String basePath = "http://www.earltech.cn:8080"+"/fishshop/";

	@Test
	public void testDeletePointCategoryGoods() {
		String targetURL = basePath + "goods_deletePointCategoryGoods.action";
		//----------------请求代码
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("shopId", "2", "utf-8"),
						 new StringPart("categoryId", "7", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		//-----------------测试代码
		List<String> needCheckParam = new ArrayList<String>();
		needCheckParam.add("fishPhoto");
		needCheckParam.add("totalNowNumber");
		needCheckParam.add("categoryId");
		
		normalListAssert(sendHttpRequest, needCheckParam, null);
	}
}