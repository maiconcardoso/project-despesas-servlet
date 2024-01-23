package com.despesas.actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.dao.DespesasDao;

public class RemoveDespesas implements Action{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
	   
		DespesasDao dao = new DespesasDao();
		String id = request.getParameter("id");
		try {
			dao.delete(Integer.parseInt(id));
			return "/controladora?action=ListaDespesas";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
