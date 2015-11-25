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

public class UserFileUploadApp {
	private File targetFile;

	public static void main(String[] args) {
		new UserFileUploadApp().dod();
	}
	
	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/user_updateUserImg.action";
		targetFile = new File(
				"D:/Favorites/test/test.jpg");

		PostMethod filePost = new PostMethod(targetURL);

		try {
			
			Part[] parts = { 
			 new FilePart("userFile.file", targetFile)
//			,new FilePart("userFile.file", new File("D:/Favorites/test/QQ图片20150623221402.jpg"))
			,new StringPart("userId", "2","utf-8")
			};
			HttpMethodParams params = filePost.getParams();
//			String contentCharset = params.getContentCharset();f
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