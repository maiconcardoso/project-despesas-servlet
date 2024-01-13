package com.despesas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;

import com.despesas.model.Despesas;

public class DespesasDao {

	private ConnectionFactory connectionFactory;
	private Connection connection = null;

	public void create() throws ClassNotFoundException, SQLException {
		String createSQL = "INSERT INTO tb_despesas (descricao, data_, valor, categoria) " + "values (?, ?, ?, ?)";
		Despesas despesas = new Despesas();
		try {
			connection = connectionFactory.connect();
			PreparedStatement pstm = connection.prepareStatement(createSQL);
			pstm.setString(1, despesas.getDescricao());
			pstm.setString(2, despesas.getData().toString());
			pstm.setDouble(3, despesas.getValor());
			pstm.setString(4, despesas.getCategoria());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
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
