package com.earl.shopping.action.fileupload;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class CategoryFileUploadApp {

	private File targetFile;

	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/category_addCategory.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");

		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {
			
			Part[] parts = { 
			 new FilePart("categoryFile.file", targetFile)
			,new FilePart("categoryFile.file", new File("C:/Users/Administrator/Desktop/struts2流程图.png"))
			,new StringPart("categorySimpleName", "东星白班鱼","utf-8")
			,new StringPart("categoryAcademicName", "东星白班鱼","utf-8")
			,new StringPart("getType", "3","UTF-8")
			,new StringPart("categoryEnglishName", "东星白班鱼","utf-8")
			,new StringPart("parentId", "","utf-8")
			,new StringPart("unit", "1","utf-8")
			,new StringPart("totalSellNumber", "9","utf-8")
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

	public static void main(String[] args) {
		new CategoryFileUploadApp().dod();
	}

}