package com.ncloudscaner.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.ncloudscaner.impl.spider.AlinksImplBAK;
import com.ncloudscaner.scripts.Noscript;

public class Spider implements Runnable {
	private String url;
	private String extra;
	private int mod;
	private int num;
	public Spider(){
		this.num = 1;
	}
	public  Spider  create(String Param){
		this.url = Param;
		this.extra = "";
		System.out.print("axx");
		return this;
	}
	public Spider setThread(int Num){
		
		if (num>9)
		this.num=9;
		if (num<=0)
		this.num=1;
		else
		this.num = Num;
		return this;
	}
	public Spider setMod(String Mod){
		if(Mod.equals("dircheck"))
			this.mod = 1;
		if(Mod.equals("spider"))
			this.mod = 2;
		if(Mod.equals("sqlinjection"))
			this.mod = 3;
		return this;
	}
	public  void  run(){
		
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
