package com.ncloudscaner.core;
/*
 * @Summary:NCloudScanner是一个扫描 的框架，我建造这个框架的原因就是因为作为
 * 		              一个苦逼的工人，平时没时间去更新系统，只能利用这个扫描器去扫描有趣的
 * 		             内容与网友分享！
 * @Author:Hua-XiaoBai
 * @Class:NCGetVersion
 * @Fucntion:返回 系统版本
 * 
 */
public class NCGetVersion {
	private static  String version = "1.0.1";
	private static  String update  = "http://www.ncloudnet.com/upldate/check";
	public String getVersion(){
		return version;
	}
}
