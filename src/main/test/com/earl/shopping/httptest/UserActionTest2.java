package com.earl.shopping.httptest;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class UserActionTest2 {

	 private File targetFile;

    public void dod(){
    	String targetURL = "http://localhost:8080/fishshop/user_userLogin.action";
     	targetFile = new File("C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
    	
     	HttpClient client = new HttpClient();
    	PostMethod filePost = new PostMethod(targetURL);
//    	filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
//                cbxExpectHeader.isSelected());
    	NameValuePair userName   = new NameValuePair("userName", "易临风");
        NameValuePair password      = new NameValuePair("password", "798555920");
                try {
                    Part[] parts = {
                        new FilePart("categoryFile.file", targetFile)
//                        new FilePart(targetFile.getName(), targetFile)
                    };
                    filePost.setRequestBody(new NameValuePair[] {userName, password});
                    filePost.setRequestEntity(
                        new MultipartRequestEntity(parts, filePost.getParams())
                        );
                    client.getHttpConnectionManager().
                        getParams().setConnectionTimeout(5000);
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
   	new UserActionTest2().dod();
   }
      
}