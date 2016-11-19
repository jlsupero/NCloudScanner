package com.ncloudscaner.domains;

import java.util.HashMap;

public class LinksTree {
	private String TreeRoot;
	private String LeftNode;
	private String RightNode;
	private HashMap<String,String> urlMap;
	private int count;
	public  LinksTree(String root){
		this.TreeRoot = root;
		this.urlMap = new HashMap<String,String>();
		this.RightNode = root;
	}
	public void setUrlMap(String key,String url){
		urlMap.put(key, url);
	}
	public void setLeftNode(String leftNode){
		this.LeftNode = leftNode;
	}
	public void setRightNode(String rightNode){
		this.RightNode = rightNode;
	}
	public void setTreeRoot(String treeRoot){
		this.TreeRoot = treeRoot;
	}
	
	public HashMap<String,String> getUrl(){
		return urlMap;
	}
	public void setCount(){
		this.count++;
	}
	public String getTreeRoot(){
		return TreeRoot;
	}
	public String getLeftNode(){
		return LeftNode;
	}
	public String getRightNode(){
		return RightNode;
	}
	public int getCount(){
		return count;
	}

}
