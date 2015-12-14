package com.earl.shopping.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class CommentActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		String[] lala = { "classpath*:applicationContext-*.xml" };
		return lala;
	}

	@Test
	public void testGetShopComment() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("shopId", "1");
		request.addParameter("pageInfo.size", "5");
		request.addParameter("pageInfo.indexPageNum", "1");// 捕捞方式

		String res = executeAction("/comment_getShopComment.action");
		System.out.println(res);
	}
	
	@Test
	public void testGetUserComment() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("userId", "1");
		request.addParameter("pageInfo.size", "5");
		request.addParameter("pageInfo.indexPageNum", "1");// 捕捞方式
		String res = executeAction("/comment_getUserComment.action");
		System.out.println(res);
	}
	
	@Test
	public void testAddComment() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");

		request.addParameter("userId", "5");
		request.addParameter("shopId", "5");
		request.addParameter("ordersId", "11111120");
		request.addParameter("commentType", "-1");
		request.addParameter("content", "不错。我只是来测试而已");
		request.addParameter("weightQuality", "3");
		request.addParameter("freshQuality", "2");
		request.addParameter("speedQuality", "4");
		request.addParameter("anonymity", "1");

		String res = executeAction("/comment_addComment.action");
		System.out.println(res);
	}
	

}
