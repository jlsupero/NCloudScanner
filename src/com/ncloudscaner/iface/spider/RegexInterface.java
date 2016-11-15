package com.ncloudscaner.iface.spider;

import java.util.ArrayList;

public interface RegexInterface {
	

	String doFilter(String content, ArrayList<String> regexlist);
}
