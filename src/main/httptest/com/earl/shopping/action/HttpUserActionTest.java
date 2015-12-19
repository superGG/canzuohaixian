package com.earl.shopping.action;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class HttpUserActionTest extends HttpBaseActionTest{

	private File targetFile;

    public void dod(){
    	String targetURL = "http://localhost:8080/fishshop/user_userLogin.action";
     	targetFile = new File("D:/Favorites/test/257667_880_510_70.jpg");
    	
     	HttpClient client = new HttpClient();
    	PostMethod filePost = new PostMethod(targetURL);
    	filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
                true);
//    	phoneNumber:18312687412|password:123456| 
    	NameValuePair userName   = new NameValuePair("phoneNumber", "18312687412");
        NameValuePair password      = new NameValuePair("password", "123456");
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
				new StringPart("phoneNumber", "18312687412", "utf-8")
				,new StringPart("password", "123456", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
    
    @Test
   	public void testSmsCodeOfRegister() {
   		String targetURL = basePath
   				+ "user_smsCodeOfRegister.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		
//   		for (int i = 0; i < 10; i++) {
   			Part[] parts = { 
   					new StringPart("phoneNumber", "18320489492", "utf-8")
   			};
   			String sendHttpRequest = sendHttpRequest(filePost, parts);
   			System.out.println(sendHttpRequest);
//		}
   		
   	}
    
    @Test
   	public void testUpdatePassword() {
   		String targetURL = basePath
   				+ "user_updatePassword.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
   				new StringPart("userId", "14", "utf-8")
   				,new StringPart("password", "1234567", "utf-8")
   				,new StringPart("newPassword", "123456", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testUpdateUserImg() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_updateUserImg.action";
   		targetFile = new File("D:\\Favorites\\照片\\hdImg_6ffbf6a411fde926bce67c5691b5862d-002.jpg");

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
   				new FilePart("userFile.file", targetFile)
   				,new StringPart("userId", "14", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testUpdateUser() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_updateUser.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
   				new StringPart("userId", "14", "utf-8")
   				,new StringPart("userName", "superGG", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testFindAllUser() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_findAllUser.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
//   				new StringPart("userId", "14", "utf-8")
//   				,new StringPart("userName", "superGG", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testGetVerifyFarmers() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_getVerifyFarmers.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
//   				new StringPart("userId", "14", "utf-8")
//   				,new StringPart("userName", "superGG", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testGetVerifyFishman() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_getVerifyFishman.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
//   				new StringPart("userId", "14", "utf-8")
//   				,new StringPart("userName", "superGG", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
    @Test
   	public void testAddUser() throws FileNotFoundException {
   		String targetURL = basePath
   				+ "user_addUser.action";

   		PostMethod filePost = new PostMethod(targetURL);

   		Part[] parts = { 
   				new StringPart("phoneNumber", "18320489492", "utf-8")
   				,new StringPart("verifyCode", "573797", "utf-8")
   				,new StringPart("password", "123456", "utf-8")
   		};
   		String sendHttpRequest = sendHttpRequest(filePost, parts);
   		System.out.println(sendHttpRequest);
   	}
    
}