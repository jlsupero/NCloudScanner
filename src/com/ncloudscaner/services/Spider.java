package com.ncloudscaner.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.ncloudscaner.impl.spider.AlinksImpl;
import com.ncloudscaner.scripts.Noscript;

public class Spider implements Runnable {
	private String url;
	private String extra;
	public Spider(){
		System.out.println("s");
	}
	public  Spider  create(String url){
		this.url = url;
		this.extra = "";
		System.out.print("axx");
		return this;
	}
	public synchronized  void  run(){
		AlinksImpl rimpl = new AlinksImpl(url,"");
		try {
			rimpl.getUrl(url, extra);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
