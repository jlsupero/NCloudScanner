package com.ncloudscaner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.*;

import com.ncloudscaner.core.*;
import com.ncloudscaner.domains.LinksTree;
import com.ncloudscaner.impl.spider.AlinksImpl;
import com.ncloudscaner.impl.spider.ContentImpl;
public class test {
	private static Logger logger = Logger.getLogger(test.class);  
 public static void main(String[] args) throws IOException{
	 BufferedReader br = new  BufferedReader(new InputStreamReader(new FileInputStream("c:\\noscriptk.txt"),"utf-8"));
	 String  str;
	 StringBuilder sb = new StringBuilder();
	 while((str=br.readLine())!=null){
		 
		 sb.append(str+"\n");
		
	 }	
	 String  treeRoot = "http://www.163.com/sp/";
	 AlinksImpl l = new AlinksImpl();
	 l.setTree(new LinksTree());
	 l.setUrl("http://www.163.com/sp/");
	 l.setUrl("../ac");
	 LinksTree ls =l.getTree();
	System.out.println(ls.getTreeRoot()+ls.getRightNode());
		/*
	 ContentImpl c = new ContentImpl();
	 HashMap<String,String> b = new HashMap<String,String>();
	 b.put("title", "title:\"(.*?)\"");
	 String content = "title:\"xxxx\"xxxxx";
	 c.returnContent(b, content, 0);
	 logger.info(c.getTitle());
	 */
	// logger.info(new NCGetVersion().getVersion());
 }
}
