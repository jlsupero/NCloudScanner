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
import com.ncloudscaner.domains.LinksTree;
import com.ncloudscaner.impl.spider.AlinksImpl;
import com.ncloudscaner.services.Spider;


public class NCSCore {
	private static ArrayList<String> list;
	public static void _init(String[] args) throws IOException{
		
		//Spider spider = new Spider().create("http://www.noscriptk.com/");
		AlinksImpl impl = new AlinksImpl("http://www.noscriptk.com/","");
		Thread t1 = new Thread(impl);
		Thread t2 = new Thread(impl);
		t1.start();
		t2.start();
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
		AlinksImpl rimpl  = new AlinksImpl();
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
		
		/*
		AlinksImpl reg = new AlinksImpl();
		String[] r = {"<a(.*?)href=\"","\""};
		LinksTree urlfilter = reg.getUrl("http://tieba.baidu.com/f?kw=%B7%F0%C9%BD%D2%BB%D6%D0&fr=ala0&tpl=5","<a(.*?)href=\"(.*?)\"", r,"noscript");
		HashMap<String,String> map = urlfilter.getUrl();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			System.out.println(key+":"+map.get(key));
		}*/
		
		_init(args);
		
		

	}
	
}
