package com.ncloudscaner.iface;

import com.ncloudscaner.domains.Configure;

public interface ConfigLoader {
	Configure configure;
	public void start(String filename);
	
}
