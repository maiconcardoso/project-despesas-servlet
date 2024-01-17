package com.despesas.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T, K> {
	
	public boolean create(T obj) throws ClassNotFoundException,  SQLException; 
	public boolean update(T obj) throws ClassNotFoundException, SQLException;
	public List<T> readAll() throws ClassNotFoundException, SQLException;
	public boolean delete(K id) throws ClassNotFoundException, SQLException;
	public T findById(K id) throws ClassNotFoundException, SQLException;
}
