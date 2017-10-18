/**
 * 
 */
package com.hc.test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zhangwen
 *
 */
public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			Properties prop = new Properties();
			InputStream is = TestConfig.class.getClassLoader().
 					getResourceAsStream("com/hc/test/db.properties");
			prop.load(is);
			is.close();
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			System.out.println(url);
			System.out.println(driver);
			
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn  != null) {
			conn.close();
		}
	}

}
