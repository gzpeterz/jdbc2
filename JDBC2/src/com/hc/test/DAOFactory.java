package com.hc.test;
import java.sql.*;

public class DAOFactory {
	public static StudentDAO getStudentDAO() throws SQLException {
		return new StudentDAO();
	}
}
