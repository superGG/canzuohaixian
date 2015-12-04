package com.earl.shopping.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpSeaRecordActionTest extends HttpBaseActionTest{

	 @SuppressWarnings("unused")
	private File targetFile;

    @Test
	public void testAddSeaRecord() {
		String targetURL = basePath
				+ "searecord_addSeaRecord.action";

		PostMethod filePost = new PostMethod(targetURL);

		Part[] parts = { 
				new StringPart("shopId", "1", "utf-8")
				,new StringPart("startSeeTime", "2015-12-04 17:13:30", "utf-8")
				,new StringPart("endSeeTime", "2015-12-05 17:13:30", "utf-8")
				,new StringPart("shipportId", "1", "utf-8")
		};
		String sendHttpRequest = sendHttpRequest(filePost, parts);
		System.out.println(sendHttpRequest);
	}
    
    @Test
    public void testsdlfj(){
    	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    	String jsonString = gson.toJson(new Date(System.currentTimeMillis()),Date.class);
    	System.out.println(jsonString);
    }
}