package com.earl.shopping.action;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class UserActionTest2 {

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
	
   public static void main(String[] args) {
   	new UserActionTest2().dod();
   }
      
}