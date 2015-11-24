package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class HttpCategoryActionTest {

	@SuppressWarnings("unused")
	private File targetFile;


	@Test
	public void testGetGoodsShops(){
		String targetURL = "http://192.168.1.107:8080/fishshop/category_getGoodsShops.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {
			Part[] parts = { 
//			 new FilePart("categoryFile.file", targetFile)
//			,new FilePart("categoryFile.file", new File("D:/Favorites/test/宋文光.jpg"))
			new StringPart("categoryId", "7","utf-8")
			,new StringPart("pageInfo.indexPageNum", "1","utf-8")
			,new StringPart("pageInfo.size", "3","UTF-8")
			// new FilePart(targetFile.getName(), targetFile)
			};
			HttpMethodParams params = filePost.getParams();
//			String contentCharset = params.getContentCharset();
			params.setContentCharset("utf-8");
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(50000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
			} else {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
	}
	
//	public static void main(String[] args) {
//		new CategoryActionTest().dod();
//	}

}