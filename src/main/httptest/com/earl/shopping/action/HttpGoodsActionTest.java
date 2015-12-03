package com.earl.shopping.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

import com.earl.fishshop.domain.goods.GoodsPo;
import com.earl.fishshop.helper.JsonHelper;

public class HttpGoodsActionTest extends HttpBaseActionTest {

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
	
	@Test
	public void testxxx(){
		GoodsPo goodsPo = new GoodsPo();
		goodsPo.setPrice(34.5);
		goodsPo.setGoodsId(1L);
		ArrayList<GoodsPo> arrayList = new ArrayList<GoodsPo>();
		arrayList.add(goodsPo);
		GoodsPo goodsPo2 = new GoodsPo();
		goodsPo2.setPrice(36.5);
		goodsPo2.setGoodsId(4L);
		arrayList.add(goodsPo2);
		String json = JsonHelper.toJson(arrayList);
		System.out.println(json);
	}
	
	@Test
	public void testUpdateGoodPrice() {
		String targetURL = basePath + "goods_updateGoodPrice.action";
		//----------------请求代码
		PostMethod filePost = new PostMethod(targetURL);
		Part[] parts = { new StringPart("goodsList", "[{\"goodsId\":1,\"price\":34.5},{\"goodsId\":4,\"price\":36.5}]", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
		//-----------------测试代码
		List<String> needCheckParam = new ArrayList<String>();
		needCheckParam.add("fishPhoto");
		needCheckParam.add("totalNowNumber");
		needCheckParam.add("categoryId");
		
//		normalListAssert(sendHttpRequest, needCheckParam, null);
	}
}