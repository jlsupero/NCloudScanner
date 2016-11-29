package com.ncloudscaner.impl.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ncloudscaner.domains.LinksTree;
import com.ncloudscaner.iface.spider.RegexInterface;
import com.ncloud.extend.function.*;
public class AlinksImpl implements Runnable {
	private int i;
	private HashMap<String,String> urlMap;
	private String urlMap_key,url;
	LinksTree linksTree;
	public AlinksImpl(String Url,String extra){
		this.i = 0;
		this.linksTree = new LinksTree(Url);
		this.url=Url;
	}
	
	public boolean urlFilter(String url){
		urlMap_key =  toHash(url);
		
		if(linksTree.getUrl().containsKey(urlMap_key))
			return true;
		else
			return false;
	}
	private boolean testCode(String url) throws IOException{
		URL urlx = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) urlx.openConnection();
		if(conn.getResponseCode()==404){
			return false;
		}else{
			return true;
		}
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
	public  void getUrl(String urlroot,String extra) throws UnsupportedEncodingException, IOException{
		LinksTree tree = linksTree;
		String[] domain = {".com",".net",".me",".org",".cn",".xin"};
		String Root = tree.getTreeRoot();
		String Extra = extra;
		String urla,urlRoot,urlExtra;
		URL url = new URL(tree.getRightNode()+Extra);
		String[] replace = {"<a(.*?)href=\"","\""};
		String  regex= "<a(.*?)href=\"(.*?)\"";
		HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
		String root= tree.getTreeRoot()+"/";
		if(httpconn.getResponseCode()!=404){
			BufferedReader bf = new BufferedReader(new InputStreamReader(httpconn.getInputStream(),"utf-8"));
			String str;
			while((str=bf.readLine())!=null){
				Pattern pattern  = Pattern.compile(regex);
				Matcher m = pattern.matcher(str);
				if(m.find()){
					str = m.group();
					for(int i=0;i<=replace.length-1;i++){
						str = str.replaceAll(replace[i], "");	
					}
					if(str.startsWith("http")){
						tree.setTreeRoot(str.substring(0,str.lastIndexOf("/")+1));
						str = str.substring(str.lastIndexOf("/")+1);
						
					}
					/*
					else{
						if(str.startsWith("/")){
							for(String end:domain){
								if(tree.getTreeRoot().endsWith(end))
									tree.setTreeRoot(tree.getTreeRoot().substring(0,tree.getTreeRoot().lastIndexOf(end)+1));
								else{
									tree.setTreeRoot(tree.getTreeRoot()+"/");
									//System.out.println("begin:"+tree.getRightNode()+Extra);
								}
							}
						}
					}
						*/
						if((!str.contains("#"))&&(!str.contains("javascript"))){
							if(!urlFilter(tree.getTreeRoot()+str)){
								linksTree.setUrlMap(urlMap_key, tree.getTreeRoot()+str);
								linksTree.setCount();
								System.out.println(tree.getTreeRoot()+str+":"+linksTree.getCount()+":"+urlMap_key);
								getUrl(tree.getTreeRoot(),str);
							}
						}
				}
			}
		}
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			getUrl(this.url,"");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}