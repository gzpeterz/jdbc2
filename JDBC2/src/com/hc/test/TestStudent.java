/**
 * 
 */
package com.hc.test;

import java.sql.SQLException;

/**
 * @author zhangwen
 *
 */
public class TestStudent {

	public static void main(String[] args) {
		try {
			Student stu = new Student("zhang", 33, "ÄÐ", 3);
			System.out.println(stu);
			// StudentDAO dao = new StudentDAO();
			DAOFactory.getStudentDAO().save(stu);
			
			System.out.println(stu);
			stu = DAOFactory.getStudentDAO().findById(5);
			System.out.println(stu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
