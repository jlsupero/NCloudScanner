package com.ncloudscaner.impl.spider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import com.ncloudscaner.domains.SpiderSciptLoader;

public class ContentImpl {
	
	private SpiderSciptLoader ssl;
	public ContentImpl(){
		ssl = new  SpiderSciptLoader();
		ssl.setTitle("xxx");
	}
	public String getTitle(){
		return ssl.getTitle();
	}
	public  boolean returnContent(HashMap<String,String> RegexMap,String Content,int flag){
		//flag : 0-生成文件;1;打印 
		
		try{
			HashMap<String,String> result = new HashMap<String,String>();
			Iterator it = RegexMap.keySet().iterator();
			String key;
			while(it.hasNext()){
				
				key = it.next().toString();
				result.put(key, doFilter(Content,(String)RegexMap.get(key)));
			}
			Iterator x = result.keySet().iterator();
			
			while(x.hasNext()){
				System.out.println(result.get(x.next()));
			}
		}catch(Exception e){
			return false;
		}
		return true;
		
	}
	public String doFilter(String Content,String regex){
		
		Matcher m = Pattern.compile(regex).matcher(Content);
		if(m.find()){
			return m.group();
		}
		else{
			return null;
		}
	}
}
