package com.despesas.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaDespesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		String valor = request.getParameter("valor");
		String categoria = request.getParameter("categoria");
		
		System.out.println("Descrição: " + descricao);
		System.out.println("Data: " + data);
		System.out.println("Valor: " + valor);
		System.out.println("Categoria: " + categoria);
	}
}
