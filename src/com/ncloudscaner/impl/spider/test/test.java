package com.ncloudscaner.impl.spider.test;
import com.ncloudscaner.impl.spider.ContentImpl;
public class test {

	public static void main(String args){
		ContentImpl impl = new  ContentImpl(null);
		String content = "<a href=\"xxxx\" >HelloWorld</a>";
		String Regex = "keep.:>(.*?)<:::del.;>:::del.:<";
		System.out.println(impl.doFilter(content, Regex));
	}
}
