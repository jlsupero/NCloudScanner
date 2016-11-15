package com.ncloudscaner.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.ncloudscaner.impl.spider.RegexImpl;
import com.ncloudscaner.scripts.Noscript;

public class Spider {
	private String url;
	public  Spider  create(String url){
		this.url = url;
		return this;
	}
	public void  run() throws IOException{
		RegexImpl rimpl = new RegexImpl();
		try {
			Noscript ns = new Noscript(url);
			ns.getResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
