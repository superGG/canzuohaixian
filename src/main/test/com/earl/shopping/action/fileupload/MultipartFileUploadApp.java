package com.earl.shopping.action.fileupload;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class MultipartFileUploadApp {

	private File targetFile;

	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/category_addCategory.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {
			NameValuePair categorySimpleName= new NameValuePair("categorySimpleName", "东星白班鱼");
			NameValuePair categoryAcademicName= new NameValuePair("categoryAcademicName", "东星白班鱼");
			NameValuePair getType= new NameValuePair("getType", "3");// 捕捞方式
			NameValuePair categoryEnglishName= new NameValuePair("categoryEnglishName", "东星白班鱼");
			NameValuePair parentId= new NameValuePair("parentId", "");
			NameValuePair unit= new NameValuePair("unit", "1");
			NameValuePair totalSellNumber= new NameValuePair("totalSellNumber", "0");
			NameValuePair userName = new NameValuePair("userName", "易临风");
			NameValuePair password = new NameValuePair("password", "798555920");
			
			filePost.setRequestBody(new NameValuePair[] { userName, password,categorySimpleName,categoryAcademicName,getType,categoryEnglishName,parentId,unit,totalSellNumber });
			
			Part[] parts = { new FilePart("categoryFile.file", targetFile)
			
			// new FilePart(targetFile.getName(), targetFile)
			};
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(5000);
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

	public static void main(String[] args) {
		new MultipartFileUploadApp().dod();
	}

}