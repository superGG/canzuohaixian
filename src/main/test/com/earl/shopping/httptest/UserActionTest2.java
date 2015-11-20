package com.earl.shopping.httptest;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.junit.Before;
import org.junit.Test;

import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.vo.CategoryForxxxVo;
import com.earl.shopping.action.fileupload.MultipartFileUploadApp;
import com.earl.util.FilterPropertiesUtil;

public class UserActionTest2 {

	 private File targetFile;

    public void dod(){
    	String targetURL = "http://localhost:8080/fishshop/user_userLogin.action";
     	targetFile = new File("C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
    	
    	PostMethod filePost = new PostMethod(targetURL);

//    	filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
//                cbxExpectHeader.isSelected());
    	filePost.setParameter("userName", "易临风");
    	filePost.setParameter("password", "798555920");
    	
                try {
                    Part[] parts = {
                        new FilePart("categoryFile.file", targetFile)
//                        new FilePart(targetFile.getName(), targetFile)
                    };
                    filePost.setRequestEntity(
                        new MultipartRequestEntity(parts, filePost.getParams())
                        );
                    HttpClient client = new HttpClient();
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