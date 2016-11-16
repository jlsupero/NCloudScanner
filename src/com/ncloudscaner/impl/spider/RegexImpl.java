package com.ncloudscaner.impl.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ncloudscaner.domains.UrlFilter;
import com.ncloudscaner.iface.spider.RegexInterface;
import com.ncloud.extend.function.*;
public class RegexImpl implements RegexInterface{
	private int i;
	private HashMap<String,String> urlMap;
	private String urlMap_key;
	UrlFilter urlFilter;
	public RegexImpl(){
		this.i = 0;
		this.urlFilter = new UrlFilter();
	}
	@Override
	public String doFilter(String content,ArrayList<String> regexlist) {
		// TODO Auto-generated method stub
		String  text = content;
		try{
			ArrayList<String> list = regexlist;
			Iterator it = list.iterator();
			
			while(it.hasNext()){
				text = destoryLabel(text,(String)it.next());
			}
		//Pattern pattern = Pattern.compile("<(A|a)\\s+(.*?)^(data|javascript)href=('|\")(http://|https://)(.*?)('|\")");
		}catch(Exception e){
			text=null;
		}
			return text;
	}
	public boolean findKeywords(String content,String key)
	{
		if(content.contains(key))
			return  true;
		else
			return false;
	}
	public String getValueable(String content,HashMap<String,String> regextable){
		HashMap<String,String> result = new HashMap<String,String>();
		HashMap<String,String> regex = regextable;
		Iterator  it_regex   = regex.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		String key;
		while(it_regex.hasNext()){
			key = (String)it_regex.next();	
			result.put(key, getContent(content,regex.get(key)));
		}
		Iterator  it_result  = result.keySet().iterator();
		while(it_result.hasNext()){
			key = (String)it_result.next();
			sb.append(key+":"+result.get(key)+"\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	public boolean getValueable(String content,HashMap<String,String> regextable,String filename){
		HashMap<String,String> result = new HashMap<String,String>();
		HashMap<String,String> regex = regextable;		
		Iterator  it_regex   = regex.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		String key;
		while(it_regex.hasNext()){
			key = (String)it_regex.next();	
			result.put(key, getContent(content,regex.get(key)));
		}
		Iterator  it_result  = result.keySet().iterator();
		while(it_result.hasNext()){
			key = (String)it_result.next();
			sb.append(key+":"+result.get(key)+"\n");
		}
		
		try {
			FileWriter fw = new FileWriter(filename);
			String contentx = sb.toString(),contentsub;
			BufferedWriter bw = new BufferedWriter(fw);
			boolean isgo=true;
			int flag=0;
			while((flag=contentx.indexOf("\n"))!=-1&&isgo){
				contentsub = contentx.substring(0,flag);
				bw.write(contentsub);
				bw.newLine();
				bw.flush();
				if(flag+1>contentx.length()){
					isgo =false;
				}
				else{
					contentx = contentx.substring(flag+1);
				}
			}
			bw.flush();
			fw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
		}
		return true;
	}
	public boolean urlFilter(String url){
		urlMap_key =  toHash(url);
		
		if(urlFilter.getUrl().containsKey(urlMap_key))
			return true;
		else
			return false;
		
	}
	public UrlFilter getUrl(String urlx,String regex,String[] replace,String base){
		try{
			URL url =  new URL(urlx);	
			HttpURLConnection httpconn  = (HttpURLConnection) url.openConnection();
			if(httpconn.getResponseCode()!=404){
				BufferedReader bf = new BufferedReader(new InputStreamReader(httpconn.getInputStream(),"utf-8"));
				String str;
				StringBuilder sb = new StringBuilder();
				while((str=bf.readLine())!=null){
					Pattern pattern  = Pattern.compile(regex);
					Matcher m = pattern.matcher(str);
					if(m.find()){
						str = m.group();
						for(int i=0;i<=replace.length-1;i++){
							str = str.replaceAll(replace[i], "");
						}
						if(!str.contains("htt"))
						str= base+"/"+str;
						if(!urlFilter(str)){
							urlFilter.setUrlMap(urlMap_key, str);
							getUrl(str,regex,replace,base);
						}
					}
				}
			}
		}catch(Exception e){
			return urlFilter;
		}
		return urlFilter;
	}
	private String getContent(String content,String regex){
		Pattern  pattern =  Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(content);
		String result;
		if(matcher.find()){
			result = matcher.group();
			return result;
		}else{
			return null;
		}
		
	}
	private String  destoryLabel(String content ,String regex){
		return content.replaceAll(regex, "");
	}
	private String toHash(String url){
		SecurityHandler sh = new SecurityHandler();
		try {
			return sh.encryptMD5(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}