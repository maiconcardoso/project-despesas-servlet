package com.despesas.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.dao.DespesasDao;
import com.despesas.model.Despesas;

/**
 * Servlet responsável por enviar os dados para Lista de despesa
 */
@WebServlet("/ListaDespesaServlet")
public class ListaDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DespesasDao despesasDao = new DespesasDao();
		try {
			List<Despesas> listaDespesas = despesasDao.readAll();
			request.setAttribute("listaDespesas", listaDespesas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-despesas.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
