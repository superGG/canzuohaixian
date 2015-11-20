//package com.earl.shopping.action.fileupload;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.HttpVersion;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.FileEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.params.CoreProtocolPNames;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//import com.sun.xml.internal.ws.encoding.ContentType;
//
///**
// * @author 黄祥谦.
// * @date:2015-11-19 上午11:19:57
// * @version :
// */
//public class CategoryFileUploadTest {
//
//	@Test
//	public void testSave() throws Exception {
////		SubmitPost(null, null, null, null);
//		sls();
//	}
//
//	public void SubmitPost(String url, String filename1, String filename2,
//			String filepath) {
//
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//
//		
//		String targetURL = null;// TODO 指定URL
//		File targetFile = null;// TODO 指定上传文件
//
//		targetFile = new File("C:/Users/Administrator/Desktop/SpringMVC.jpg.png");
//		targetURL = "http://localhost:8080/fishshop/category_getTopCategory.action"; // servleturl
//		HttpPost filePost = new HttpPost(targetURL);
//
//		try {
//			// 通过以下方法可以模拟页面参数提交
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			params.add(new BasicNameValuePair("name", "jack"));
//			FileEntity fileEntity = new FileEntity(targetFile);
//			fileEntity.setContentType("binary/octet-stream");
//			filePost.setEntity(fileEntity);
//			// httpclient.setConnectionTimeout(5000);
//			 System.out.println("executing request " + filePost.getRequestLine());
//			CloseableHttpResponse status = httpclient.execute(filePost);
//			if (status.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				System.out.println("上传成功");
//				// 上传成功
//			} else {
//				System.out.println("上传失败");
//				// 上传失败
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			filePost.releaseConnection();
//		}
//	}
//	public void sls(){
//		
//	HttpClient httpclient = new DefaultHttpClient();
//    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
//
//    HttpPost httppost = new HttpPost("http://localhost:9002/upload.php");
//    File file = new File("c:/TRASH/zaba_1.jpg");
//
//    FileEntity reqEntity = new FileEntity(file, "binary/octet-stream");
//
//    httppost.setEntity(reqEntity);
//    reqEntity.setContentType("binary/octet-stream");
//    System.out.println("executing request " + httppost.getRequestLine());
//    HttpResponse response = httpclient.execute(httppost);
//    HttpEntity resEntity = (HttpEntity) response.getEntity();
//
//    System.out.println(response.getStatusLine());
//    if (resEntity != null) {
//      System.out.println(EntityUtils.toString(resEntity));
//    }
//    if (resEntity != null) {
//      resEntity.consumeContent();
//    }
//
//    httpclient.getConnectionManager().shutdown();
//  }
//}
//
//}
