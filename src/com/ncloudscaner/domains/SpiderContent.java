package com.ncloudscaner.domains;

import java.util.HashMap;

public class SpiderContent {
	private String url;
	private String output;
	private int  size;
	private HashMap<String,String> rule;
	private HashMap<String,String> result;
	public void setUrl(String Url){
		this.url = Url;
	}
	public void setOutput(String Output){
		this.output = Output;
	}
	public void setRule(HashMap<String,String> Rule){
		this.rule = Rule; 
	}
	public void setResult(HashMap<String,String> Result){
		this.result = Result;
	}
	public String getUrl(){
		return url;
	}
	public String getOutput(){
		return output;
	}
	public int getSize(){
		return result.size();
	}
	public HashMap<String,String> getRule(){
		return rule;
	}
	public HashMap<String,String> getResult(){
		return result;
	}
}

