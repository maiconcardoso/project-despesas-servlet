package com.despesas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.despesas.model.Despesas;




public class DespesasDao implements IDao<Despesas, Integer>{

	private Connection connection = null;

	@Override
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

	public List<Despesas> readAll() throws SQLException, ClassNotFoundException {
		
		String readSQL = "SELECT * FROM tb_despesas";
		List<Despesas> listaDespesas = new ArrayList<>();
		
		try {
			connection = new ConnectionFactory().connect();
			PreparedStatement pstm = connection.prepareStatement(readSQL);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Despesas despesas = new Despesas();
				despesas.setId(rs.getInt("id"));
				despesas.setDescricao(rs.getString("descricao"));
				despesas.setData((rs.getDate("data_").toLocalDate()));
				despesas.setValor(rs.getDouble("valor"));
				despesas.setCategoria(rs.getString("categoria"));
				listaDespesas.add(despesas);
			}
			return listaDespesas;
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());	
			return null;
		} finally {
			connection.close();
		}
		
	}
	
	@Override
	public boolean update(Despesas obj) throws SQLException, ClassNotFoundException {
		return false;
	}

	@Override
	public boolean delete(Despesas obj) throws SQLException, ClassNotFoundException {
		return false;
	}

	@Override
	public Despesas findById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
