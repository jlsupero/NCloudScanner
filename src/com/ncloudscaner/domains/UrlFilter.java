package com.ncloudscaner.domains;

import java.util.HashMap;

public class UrlFilter {
	private HashMap<String,String> urlMap;
	public UrlFilter(){
		this.urlMap = new HashMap<String,String>();
	}
	public void setUrlMap(String key,String url){
		urlMap.put(key, url);
	}
	public HashMap<String,String> getUrl(){
		return urlMap;
	}
}
