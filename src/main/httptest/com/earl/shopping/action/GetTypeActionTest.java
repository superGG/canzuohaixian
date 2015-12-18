package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

public class GetTypeActionTest extends HttpBaseActionTest{

	private File targetFile;

    
    @Test
	public void testGetFarmerGetType() {
		String targetURL = basePath
				+ "gettype_getFarmerGetType.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
//				new StringPart("phoneNumber", "18312687412", "utf-8")
//				,new StringPart("password", "123456", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
    
    
    
}