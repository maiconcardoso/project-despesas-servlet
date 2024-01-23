package com.despesas.actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.dao.DespesasDao;
import com.despesas.model.Despesas;

public class ListaDespesas implements Action{

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DespesasDao despesasDao = new DespesasDao();
		try {
			List<Despesas> listaDespesas = despesasDao.readAll();
			request.setAttribute("listaDespesas", listaDespesas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-despesas-scriptlet.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
