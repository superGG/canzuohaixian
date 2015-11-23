package com.earl.shopping.action.fileupload;

import java.io.File;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class FishmanFileUploadApp {

	private List<File> targetFile;

	public void dod() {
		String targetURL = "http://localhost:8080/fishshop/fishman_authenticationFishman.action";
		targetFile.add(new File(
				"D:/Favorites/test/test.jpg"));

		targetFile.add(new File(
				"D:/Favorites/test/宋文光.jpg"));
		PostMethod filePost = new PostMethod(targetURL);

		// filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
		// cbxExpectHeader.isSelected());
		try {

			Part[] parts = { new FilePart("fishmanFileVo.file", targetFile.get(0)),
					new FilePart("fishmanFileVo.file", targetFile.get(1)),
					new StringPart("userId", "1")
			// new FilePart(targetFile.getName(), targetFile)
			};
			HttpMethodParams params = filePost.getParams();
			// String contentCharset = params.getContentCharset();
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
		new FishmanFileUploadApp().dod();
	}

}