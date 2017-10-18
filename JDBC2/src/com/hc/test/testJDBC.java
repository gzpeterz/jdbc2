/**
 * 
 */
package com.hc.test;
import java.sql.*;
import java.util.*;

/**
 * @author zhangwen
 *
 */
public class testJDBC {

	public static void main(String[] args) throws Exception {
		/*
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "peter", "peter");
				*/
		//  使用 DBUtil 类 来连接 数据库  
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from student";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getString(1) + " ");
			System.out.print(rs.getString(2) + "\t" );
			System.out.print(rs.getString(3) );
			System.out.println(" ");
		}
		rs.close();
		stmt.close();
		DBUtil.closeConnection(conn);
		//conn.close();

	}
}
