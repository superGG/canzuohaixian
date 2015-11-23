package com.earl.shopping.action.fileupload;

import java.io.File;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> b7273c5971bf0aad7d48bdf7343fc1ac1e3fc166

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class FishmanFileUploadApp {

<<<<<<< HEAD
	private File targetFile;

	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/fishman_authenticationFishman.action";
		targetFile = new File(
				"C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
=======

	public static void main(String[] args) {
		new FishmanFileUploadApp().dod();
	}
	private List<File> targetFile;

	public void dod() {
		String targetURL = "http://192.168.1.107:8080/fishshop/fishman_authenticationFishman.action";
		targetFile = new ArrayList<File>();
		targetFile.add(new File(
				"D:/Favorites/test/test.jpg"));
>>>>>>> b7273c5971bf0aad7d48bdf7343fc1ac1e3fc166

		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {
<<<<<<< HEAD
			
			Part[] parts = { 
			 new FilePart("fishmanFile.file", targetFile)
			,new FilePart("fishmanFile.file", new File("C:/Users/Administrator/Desktop/struts2流程图.png"))
			,new StringPart("userId", "1","utf-8")
//			,new StringPart("categorySimpleName", "东星白班鱼","utf-8")
//			,new StringPart("categoryAcademicName", "东星白班鱼","utf-8")
//			,new StringPart("getType", "3","UTF-8")
//			,new StringPart("categoryEnglishName", "东星白班鱼","utf-8")
//			,new StringPart("parentId", "","utf-8")
//			,new StringPart("unit", "1","utf-8")
//			,new StringPart("totalSellNumber", "9","utf-8")
=======
			Part[] parts = { new FilePart("fishmanFile.file", new File(
							"D:/Favorites/test/test.jpg"))
					,new FilePart("fishmanFile.file", new File(
							"D:/Favorites/test/宋文光.jpg"))
					,new StringPart("userId", "1","utf-8")
>>>>>>> b7273c5971bf0aad7d48bdf7343fc1ac1e3fc166
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


}