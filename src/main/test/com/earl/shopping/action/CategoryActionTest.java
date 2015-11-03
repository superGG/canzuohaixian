package com.earl.shopping.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class CategoryActionTest extends StrutsSpringTestCase {

	@Override
	protected String[] getContextLocations() {
		// TODO Auto-generated method stub
			String [] lala =	{"classpath*:applicationContext-*.xml"};  
			return lala;
	}
	
	@Test
	public void testSave() throws Exception{
//		request.addHeader("Content-type", " text/html; charset=utf-8");
		
//		 request.addParameter("categorySimpleName", "东星白班鱼");  
//		 request.addParameter("categoryAcademicName", "东星白班鱼");  
//		 request.addParameter("getType", "3");//捕捞方式  
//		 request.addParameter("categoryEnglishName", "东星白班鱼");  
//		 request.addParameter("parentId", "");  
//		 request.addParameter("fishPhoto", "localhost:8080//aaa.jpg");  
//		 request.addParameter("unit", "1");  
//		 request.addParameter("totalSellNumber", "0");  
		
		//使用下面方式，不能直接用struts的modeldriven
		 request.addParameter("model", "{" +
		 		"\"categorySimpleName\" : \"东星白班鱼\"" +
		 		",\"categoryAcademicName\": \"东星白班鱼\"" +
		 		",\"getType\": \"3\"" +
		 		",\"categoryEnglishName\": \"东星白班鱼\"" +
		 		",\"categoryEnglishName\": \"东星白班鱼\"" +
		 		",\"fishPhoto\": \"localhost:8080//aaa.jpg\"" +
		 		",\"unit\": \"1\"" +
		 		",\"totalSellNumber\": \"0\"" +
		 		"}");
		 
	     String res=executeAction("/category_addCategory.action");  
	}

	@Test
	public void testGetAllCategory() throws UnsupportedEncodingException, ServletException{
		String res=executeAction("/category_getAllCategory.action");  
		System.out.println(res);
	}
	
	
}
