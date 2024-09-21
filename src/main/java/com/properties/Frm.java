package com.properties;

public class Frm {
	
	private Frm() {
		
	}

	
	private static Frm fr;
	public static Frm getInstancefrm() {
		
		if (fr == null) {
			fr = new Frm();
		}
		return fr;
	}
	public ConfigurationReader getInstanceConfigurationReader() {
		
		ConfigurationReader cf = new ConfigurationReader();
		return cf;
	}
}
