package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class HttpUserActionTest extends HttpBaseActionTest{

	 @SuppressWarnings("unused")
	private File targetFile;

    public void dod(){
    	String targetURL = "http://localhost:8080/fishshop/user_userLogin.action";
     	targetFile = new File("C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
    	
     	HttpClient client = new HttpClient();
    	PostMethod filePost = new PostMethod(targetURL);
    	filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
                true);
    	NameValuePair userName   = new NameValuePair("userName", "IMissYou");
        NameValuePair password      = new NameValuePair("password", "798555920");
        //TODO 要先设置文件参数，在设置from表单参数，否则表单参数丢失.
                try {
                    filePost.setRequestBody(new NameValuePair[] {userName, password});
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
    
    @Test
	public void testUserLogin() {
		String targetURL = basePath
				+ "user_userLogin.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
				new StringPart("phoneNumber", "13763012723", "utf-8")
				,new StringPart("userName", "1", "utf-8")
				,new StringPart("password", "123456", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
}