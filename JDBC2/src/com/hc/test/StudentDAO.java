package com.hc.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public class StudentDAO implements DAO<Student, Integer> {
	private static final String SAVE = 
		"insert into student values (null, ?, ?, ?, ?)";
	private static final String FIND_BY_ID = 
		"select * from student where id=?";
	private static final String UPDATE = 
		"update student set name=?, age=?, sex=?, dep_id=? where id = ? ";

	@Override
	public boolean update(Student entity) throws SQLException {
		return false;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		return false;
	}

	@Override
	public Student findById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(FIND_BY_ID);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			Student stu = new Student(
				rs.getInt(1), rs.getString(2), rs.getInt(3), 
				rs.getString(4), rs.getInt(5));
			rs.close();
			pst.close();
			conn.close();
			return stu;
		} else {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			DBUtil.closeConnection(conn);
			return null;
		}
	}

	@Override
	public List<Student> findByAll() throws SQLException {
		return null;
	}

	@Override
	public boolean save(Student student) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(
			SAVE, Statement.RETURN_GENERATED_KEYS);
// 			SAVE, new String[]{"id"});
		pst.setString(1, student.getName());
		pst.setInt(2, student.getAge());
		pst.setString(3, student.getSex());
		pst.setInt(4, student.getDept_id());

		if(pst.executeUpdate() > 0) {
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			student.setId(id);
			pst.close();
			conn.close();
			return true;
		}
		if (pst != null) {
			pst.close();
		}
		DBUtil.closeConnection(conn);
		return true;
	}
}
