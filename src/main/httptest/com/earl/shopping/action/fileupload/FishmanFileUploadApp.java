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

public class FishmanFileUploadApp {
	private File targetFile;

	public static void main(String[] args) {
		new FishmanFileUploadApp().dod();
	}
	
	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/fishman_authenticationFishman.action";
		targetFile = new File(
				"D:/Favorites/test/test.jpg");

		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {
			
			Part[] parts = { 
			 new FilePart("fishmanFile.file", targetFile)
			,new FilePart("fishmanFile.file", new File("D:/Favorites/test/QQ图片20150623221402.jpg"))
			,new FilePart("fishmanFile.file", new File("D:/Favorites/test/宋文光.jpg"))
			,new FilePart("fishmanFile.file", new File("D:/Favorites/test/257667_880_510_70.jpg"))
			,new FilePart("fishmanFile.file", new File("D:/Favorites/test/wifi0s0-15815604312520b8e092d2c33a0f76e6b33525d17c_crop.jpg"))
			 ,new FilePart("fishmanFile.file", new File("D:/Favorites/test/QQ图片20151010192845.jpg"))
			,new StringPart("userId", "17","utf-8")
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