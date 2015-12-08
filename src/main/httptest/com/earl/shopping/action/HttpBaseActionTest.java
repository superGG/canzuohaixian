package com.earl.shopping.action;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Assert;

import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.vo.ResultMessage;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author 黄祥谦.
 * @date:2015-11-24 下午12:26:17
 * @version :
 */
public class HttpBaseActionTest {

//	String basePath = "http://www.earltech.cn:8080/fishshop/";
	String basePath = "http://localhost:8080/fishshop/";
//	String basePath = "http://192.168.1.111:8080/fishshop/";
	
	public String sendHttpRequest(PostMethod filePost, Part[] parts) {
		String string = null;
		try {
			HttpMethodParams params = filePost.getParams();
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
			InputStream in = filePost.getResponseBodyAsStream();
			byte[] readStream = readStream(in);
			string = new String(readStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
		return string;
	}
	
	/** 
	 * 读取流 
	 *  
	 * @param inStream 
	 * @return 字节数组 
	 * @throws Exception 
	 */  
	private byte[] readStream(InputStream inStream) throws Exception {  
	    ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
	    byte[] buffer = new byte[1024];  
	    int len = -1;  
	    while ((len = inStream.read(buffer)) != -1) {  
	        outSteam.write(buffer, 0, len);  
	    }  
	    outSteam.close();  
	    inStream.close();  
	    return outSteam.toByteArray();  
	}  
	
	public void normalListAssert(String sendHttpRequest,
			List<String> needCheckParam, String paramName) {
		ResultMessage jsonToBean = JsonHelper.jsonToBean(sendHttpRequest, ResultMessage.class);
		Assert.assertEquals("true", jsonToBean.getServiceResult().toString());
		@SuppressWarnings("unchecked")
		List<LinkedTreeMap<String,Object>> object = (List<LinkedTreeMap<String,Object>>) jsonToBean.getResultParm().get(paramName);
		for (int i = 0; i < object.size(); i++) {
			LinkedTreeMap<String, Object> linkedTreeMap = object.get(i);
			//---------------------------
			for (String string : needCheckParam) {
				Object object2 = linkedTreeMap.get(string);
				System.out.println(object2);
				Assert.assertNotNull(object2);
			}
		}
	}
	public void normalObjectAssert(String sendHttpRequest,
			List<String> needCheckParam, String paramName) {
		ResultMessage jsonToBean = JsonHelper.jsonToBean(sendHttpRequest, ResultMessage.class);
		Assert.assertEquals("true", jsonToBean.getServiceResult().toString());
		@SuppressWarnings("unchecked")
		LinkedTreeMap<String, Object> linkedTreeMap = (LinkedTreeMap<String, Object>) jsonToBean.getResultParm().get(paramName);
			//---------------------------
			for (String string : needCheckParam) {
				Object object2 = linkedTreeMap.get(string);
				System.out.println(object2);
				Assert.assertNotNull(object2);
			}
	}
}
