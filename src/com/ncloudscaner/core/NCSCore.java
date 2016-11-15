package com.ncloudscaner.core;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import com.ncloudscaner.aop.DynamicProxy;
import com.ncloudscaner.impl.spider.RegexImpl;
import com.ncloudscaner.services.Spider;


public class NCSCore {
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
		_init(args);
		
		
	}
}
