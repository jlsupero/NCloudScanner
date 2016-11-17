package com.ncloudscaner.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ncloudscaner.aop.DynamicProxy;
import com.ncloudscaner.domains.UrlFilter;
import com.ncloudscaner.impl.spider.RegexImpl;
import com.ncloudscaner.services.Spider;


public class NCSCore {
	private static ArrayList<String> list;
	public static void _init(String[] args) throws IOException{
		Spider spider = new Spider();
		spider.create("http://www.noscriptk.com").run();
	}
	public static void main(String[] args) throws IOException{
		//_init(args);
		/*
		String a ="5x";
		System.out.println(Integer.toBinaryString((byte)a.charAt(0)>>1));
		String content="<a  href=\"xxxx\">dddd</a>\ndfdfsd";
		HashMap<String,String> r = new HashMap<String,String>();
		r.put("title", "<a(\\s+?)(.*?)</a>");
		r.put("word", "df(.+?)sd");
		RegexImpl rimpl  = new RegexImpl();
		rimpl.getValueable(content, r,"c:\\ax.txt");
		*/
		//_init(args);
		/*
		URL url =  new URL("http://www.163.com");
		HttpURLConnection httpconn  = (HttpURLConnection) url.openConnection();
		BufferedReader bf = new BufferedReader(new InputStreamReader(httpconn.getInputStream(),"utf-8"));
		String str;
		StringBuilder sb = new StringBuilder();
		while((str=bf.readLine())!=null){
			Pattern pattern  = Pattern.compile("href=\"htt(.*?)\"");
			Matcher m = pattern.matcher(str);
			if(m.find()){
				str = m.group().replaceAll("href=\"", "").replaceAll("\"", ";");
				sb.append(str+"\n");
			}
		}
		System.out.println(sb.toString());
		*/
		/*
		list = new  ArrayList<String>();
		System.out.println("bgein");
		getUrl("http://www.gdkszx.com.cn/");
		Iterator<String>  it = list.iterator();
	
		
		while(it.hasNext()){
			String  str = it.next();
			System.out.println(str);
		}
		System.out.println("end");
		
		*/
		
		
		RegexImpl reg = new RegexImpl();
		String[] r = {"<a(.*?)href=\"","\""};
		UrlFilter urlfilter = reg.getUrl("http://noscriptk.com","<a(.*?)href=\"(.*?)\"", r,"noscript");
		HashMap<String,String> map = urlfilter.getUrl();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			System.out.println(key+":"+map.get(key));
		}
		
	}
	public static void getUrl(String urlx) throws UnsupportedEncodingException, IOException{
		/*
		URL url =  new URL(urlx);
		HttpURLConnection httpconn  = (HttpURLConnection) url.openConnection();
		if(httpconn.getResponseCode()!=404){
		BufferedReader bf = new BufferedReader(new InputStreamReader(httpconn.getInputStream(),"utf-8"));
		String str;
		StringBuilder sb = new StringBuilder();
		while((str=bf.readLine())!=null){
			Pattern pattern  = Pattern.compile("<a(.*?)href=\"(.*?)\"");
			Matcher m = pattern.matcher(str);
			if(m.find()){
				str = m.group().replaceAll("<a(.*?)href=\"", "").replaceAll("\"", "");
				if(!str.contains("htt"))
				str="http://www.gdrsks.gov.cn"+str;
				if((!list.contains(str))&&(!str.contains("mailto"))){
				System.out.println(str);
				list.add(str);
				getUrl(str);
				}
			}
		}
		}
		*/

	}
}
