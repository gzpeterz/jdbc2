package com.hc.test;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author zhangwen
 *
 * @param <T>  T 是对象类型
 * @param <ID>  ID 是key
 */
public interface  DAO<T, ID> {
	public boolean save(T entity) throws SQLException;
	public boolean update(T entity) throws SQLException;
	public boolean deleteById(ID id) throws SQLException;
	public T findById(ID id) throws SQLException;
	public List<T> findByAll() throws SQLException;
}
