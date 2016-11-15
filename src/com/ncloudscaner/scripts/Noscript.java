package com.ncloudscaner.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Noscript extends SpiderScript implements ScriptImpl {

	public Noscript(String url) throws Exception {
		super(url);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getResult() {
		// TODO Auto-generated method stub
		BufferedReader bf;
		try {
			System.out.println("begin");
			bf = new BufferedReader(new InputStreamReader(HttpConnection.getInputStream(),"utf-8"));
			String str;
			StringBuilder sb = new StringBuilder();
			while((str=bf.readLine())!=null){
				sb.append(str);
			}
			System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}

}
