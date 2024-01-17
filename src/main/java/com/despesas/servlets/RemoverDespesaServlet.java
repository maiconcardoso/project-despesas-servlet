package com.despesas.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.dao.DespesasDao;

/**
 * Servlet implementation class RemoverDespesaServlet
 */
@WebServlet("/removeDespesa")
public class RemoverDespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
	   
		DespesasDao dao = new DespesasDao();
		String id = request.getParameter("id");
		try {
			dao.delete(Integer.parseInt(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-despesas-scriptlet.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
