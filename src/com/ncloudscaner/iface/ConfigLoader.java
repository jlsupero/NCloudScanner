package com.ncloudscaner.iface;

import com.ncloudscaner.domains.Configure;

public interface ConfigLoader {
	Configure configure = new  Configure();
	public void start(String filename);
	
}
