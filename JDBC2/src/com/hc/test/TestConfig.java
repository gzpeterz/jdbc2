/**
 * 
 */
package com.hc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhangwen
 *
 */
public class TestConfig {

	public static void main(String[] args)  {
		String url;
		String driver;
		
		try {
			Properties prop = new Properties();
			/*
			FileInputStream fis = new FileInputStream(
				"src/com/hc/test/db.properties");
				*/
			InputStream is = TestConfig.class.getClassLoader().
 					getResourceAsStream("com/hc/test/db.properties");
			prop.load(is);
			is.close();
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			System.out.println(url);
			System.out.println(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
