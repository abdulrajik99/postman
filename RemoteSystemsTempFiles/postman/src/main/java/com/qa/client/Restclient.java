package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Restclient 
 {
	
	//get method without Header
	public CloseableHttpResponse get(String url) throws IOException
	{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse closablehttpresponse=httpClient.execute(httpget);
			return closablehttpresponse;
		
	}
	
	//get metod with headers
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws IOException
	{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		for(Map.Entry<String, String> entry:headerMap.entrySet()){
			httpget.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse closablehttpresponse=httpClient.execute(httpget);
			return closablehttpresponse;
	}

}
