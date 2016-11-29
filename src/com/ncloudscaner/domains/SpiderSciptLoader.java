package com.ncloudscaner.domains;

import java.util.HashMap;

public class SpiderSciptLoader {
	private String title;
	private String useragent;
	private String method;
	private String connection;
	private String url;
	private String urlregex;
	private HashMap<String,Object> contentmap;
	public void setTitle(String Title){
		this.title = Title;
	}
	public void setUserAgent(String UserAgent){
		this.useragent = UserAgent;
	}
	public void setMethod(String Method){
		this.method = Method;
	}
	public void setConnection(String Connection){
		this.connection = Connection;
	}
	public void setUrl(String Url){
		this.url = Url;
	}
	public void setUrlRegex(String UrlRegex){
		this.urlregex = UrlRegex;
		
	}
	public void setContentMap(HashMap<String,Object> ContentMap){
		this.contentmap = ContentMap;
	}
	public String getTitle(){
		return title;
	}
	public String getUserAgent(){
		return useragent;
	}
	public String getMethod(){
		return method;
	}
	public String getConnection(){
		return connection;
	}
	public String getUrl(){
		return url;
	}
	public String getUrlRegex(){
		return urlregex;
	}
	public  HashMap<String,Object> getContentMap(){
		return contentmap;
	}
}
