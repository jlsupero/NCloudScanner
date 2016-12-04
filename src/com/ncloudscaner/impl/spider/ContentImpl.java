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
	public ContentImpl(SpiderSciptLoader Ssl){
		this.ssl = Ssl;
	}
	public String getTitle(){
		return ssl.getTitle();
	}
	/*
	 *  @Name:returnContent
	 *  @Params:HashMap<String,String> RegexMap,String Content,int flag
	 *  		//flag : 0-生成文件;1;打印 
	 *  @Return:String
	 *  @Description:保留有用的内容
	 */
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
			
			/*
			Iterator x = result.keySet().iterator();
			
			while(x.hasNext()){
				System.out.println(result.get(x.next()));
			}
			*/
		}catch(Exception e){
			return false;
		}
		return true;
		
	}
	/*
	 *  @Name:doFilter
	 *  @Params:String Content,String Regex
	 *  @Return:String
	 *  @Description:过滤器，负责过滤内容
	 *  	Regex格式:  ":::" 作为命令的分隔符，协助分割各种指令，指令有kepp.(保留指令，注意"."不能少，否则报错);del.删除指令
	 *  			   ".:"  作为每条指令的行动和内容分隔符；
	 */
	public String doFilter(String Content,String Regex){
		try{
			String result = Content;
			if(Content!=null){
				String[] regexList = Regex.split(":::");
				for(int i=0;i<= regexList.length-1;i++){
					String regex = regexList[i];
					String[] strs=regex.split(".:");
					if(strs[0].equals("keep")){
						result = keepContent(result,strs[1]);
					}
					else if(strs[0].equals("del")){
						result = removeContent(result,strs[1]);
					}
					else{
						return "指令有误,无法进行操作 !";
					}
				}
				return result;
			}
			else{
				return null;
			}
		}catch(Exception e){
			return "指令有误,无法进行操作 !";
		}
	}
	/*
	 *  @Name:keepContent
	 *  @Params:String Content,String Regex
	 *  @Return:String
	 *  @Description:保留有用的内容
	 */
	public String keepContent(String Content,String Regex){
		Matcher m = Pattern.compile(Regex).matcher(Content);
		if(m.find()){
			return m.group();
		}
		else{
			return null;
		}
	}
	/*
	 *  @Name:removeContent
	 *  @Params:String Content,String regex
	 *  @Return:String
	 *  @Description:删除多余的内容
	 */
	public String removeContent(String Content,String regex){
		return Content.replaceAll(regex, "");
	}
}
