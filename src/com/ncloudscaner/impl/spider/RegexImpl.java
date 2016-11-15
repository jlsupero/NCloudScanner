package com.ncloudscaner.impl.spider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ncloudscaner.iface.spider.RegexInterface;

public class RegexImpl implements RegexInterface{
	private int i;
	public RegexImpl(){
		this.i = 0;
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
	
}