package com.ncloudscaner.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirScaner {
	private String file;
	public DirScaner(String filename){
		this.file = filename;
	}
	public static void scanStart(String link){
		StringBuilder sb = new StringBuilder();
		String str ;
		ArrayList<String> list = new ArrayList<String>();
		int code;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("c:\\dir.txt")));
			while((str=bf.readLine())!=null){
				list.add(str);
			}
			for(String param : list){
				URL obj = new URL(link+param);
				HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
				conn.setRequestProperty("Charset", "UTF-8");
				code = conn.getResponseCode();
				if(code!=404){
					System.out.println(link+param+">>"+code);
				}
			conn.disconnect();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Read the File error!");
		}
		
	}
	public static void main(String[] args) throws URISyntaxException, IOException{
		scanStart("http://www.noscriptk.com");
	}
}
