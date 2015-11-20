package com.earl.shopping.action.fileupload;
import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
//import org.apache.commons.httpclient.params.HttpMethodParams;

public class MultipartFileUploadApp {

	 private File targetFile;

     public void dod(){
     	String targetURL = "http://localhost:8080/fishshop/category_getTopCategory.action";
     	targetFile = new File("C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
     
     	PostMethod filePost = new PostMethod(targetURL);

//     	filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
//                 cbxExpectHeader.isSelected());
                 try {
                     Part[] parts = {
                         new FilePart("categoryFile.file", targetFile)
//                         new FilePart(targetFile.getName(), targetFile)
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
    	new MultipartFileUploadApp().dod();
    }
       
}