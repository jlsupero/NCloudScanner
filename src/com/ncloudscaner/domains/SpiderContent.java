package com.ncloudscaner.domains;

import java.util.HashMap;

public class SpiderContent {
	private String url;
	private String output;
	private int  size;
	private HashMap<String,Object> rule;
	private HashMap<String,Object> result;
	public void setUrl(String Url){
		this.url = Url;
	}
	public void setOutput(String Output){
		this.output = Output;
	}
	public void setRule(HashMap<String,Object> Rule){
		this.rule = Rule; 
	}
	public void setResult(HashMap<String,Object> Result){
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
	public HashMap<String,Object> getRule(){
		return rule;
	}
	public HashMap<String,Object> getResult(){
		return result;
	}
}

