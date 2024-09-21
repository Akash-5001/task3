package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	FileInputStream fis;

	public Properties ConfigFile() {

		File f = new File("           ");
		try {

			fis = new FileInputStream(f);

		} catch (FileNotFoundException e) {

		}
		Properties p = new Properties();
		try {
			p.load(fis);

		} catch (IOException e) {

		}
		return p;

	}

    public String getBrowser() {
	String browser  = ConfigFile().getProperty("browser");
	return browser;
    }
	public String getUrl() {
		String url  = ConfigFile().getProperty("url");
		return url;
	}
	public String getUsername() {
			String username  = ConfigFile().getProperty("username");
			return username;
	}
	public String getPassword() {
				String password  = ConfigFile().getProperty("password");
				return password;
	}
	public String getTitle() {
		String title = ConfigFile().getProperty("title");
		return title;

	}
}
	
