package com.despesas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;

import com.despesas.model.Despesas;

public class DespesasDao {

	private Connection connection = null;

	public boolean create(Despesas despesas) throws ClassNotFoundException, SQLException {
		
		String createSQL = "INSERT INTO tb_despesas (descricao, data_, valor, categoria) " + "values (?, ?, ?, ?)";
		
		try {
			connection = new ConnectionFactory().connect();
			PreparedStatement pstm = connection.prepareStatement(createSQL);
			pstm.setString(1, despesas.getDescricao());
			pstm.setDate(2, java.sql.Date.valueOf(despesas.getData())); 
			pstm.setDouble(3, despesas.getValor());
			pstm.setString(4, despesas.getCategoria());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			connection.close();
		}
	}

	public List<Despesas> readAll() {
		return null;
	}

	public void update(Despesas obj) {

	}

	public void delete(Despesas obj) {

	}

}
