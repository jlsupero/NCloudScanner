package com.ncloudscaner.scripts;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SpiderScript {
	protected String Header;
	protected String Context;
	protected String Code;
	protected String UserAgent;
	protected String Method;
	protected HttpURLConnection HttpConnection;
	protected URL  Url;
	SpiderScript(String url) throws Exception{
		this.Url = new URL(url);
		this.Method= "GET";
		this.UserAgent = "directclient";
		HttpConnection  = (HttpURLConnection) Url.openConnection();
		HttpConnection.setRequestProperty("User-Agent", "directclient");
		HttpConnection.setRequestMethod(Method);
		}
}
