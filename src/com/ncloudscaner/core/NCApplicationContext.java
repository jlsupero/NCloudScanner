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


public class NCApplicationContext {
	private String param;//URL等参数
	private String threadNum;//线程数
	private String url;//URL
	private int report;//是否上传到服务器
	private int mod;//使用模块--0:停止;1:spider;2:字典查找;3:SQL  INJECTION;
	private int debug;//是否生成日志
	public  NCApplicationContext(){
		this.debug = 1;
		this.report = 1;
	}
	/* @Name: _init;
	 * @Params: String[] args;
	 * @Return: boolean;
	 * @Description: 系统的入口，负责分配任务；
	 */
	public boolean _init(String[] args) {
		/* param -u  --url : >>this.url;
		 * param -m  --mod : >>this.mod;
		 * param --no-report :>>this.report = 0;
		 * param --no-debug : >>this.debug = 0;
		 * param -t  --thread :>> this.threadNum ;Num:0-9;
		 * For example : ncscanner -u http://www.xxx.com/ -t 3 -m spider  --no-report --no-debug
		 */
		try{
			int i=0;
			String[] input = args;
			for(String arg:input){
				switch(arg.trim().toLowerCase()){
					case "-u":
						this.url = input[i+1];break;
					case "--url":
						this.url = input[i+1];break;
					case "-m":
						if(input[i+1].equalsIgnoreCase("spider"))
							this.mod = 1;
						if(input[i+1].equalsIgnoreCase("dir"))
							this.mod = 2;
						if(input[i+1].equalsIgnoreCase("sql"))
							this.mod = 3;	
						break;
					case "--mod":
						if(input[i+1].equalsIgnoreCase("spider"))
							this.mod = 1;
						if(input[i+1].equalsIgnoreCase("dir"))
							this.mod = 2;
						if(input[i+1].equalsIgnoreCase("sql"))
							this.mod = 3;
						break;
					case "--no-report":
						this.report = 0;break;
					case "--no-debug":
						this.debug = 0;break;
					case "-t":
						this.threadNum = input[i+1];break;
					case "--thread":
						this.threadNum = input[i+1];break;
				}
				i++;
			}
			if((url==null)||(Integer.valueOf(mod)==0)||(!url.startsWith("http"))){
				return false;
		}
			else{
			//System.out.println("URL:"+url+"--Mod:"+mod+"--Report"+report+"--DEBUG:"+debug+"Thread:"+threadNum);
			return true;
		}
	}catch(Exception e){
		return false;
	}
}
	/*
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
		
		
		
		

	//}
	//*/
}
