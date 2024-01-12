package com.despesas.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.model.Despesas;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdicionaDespesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String descricaoStr = request.getParameter("descricao");
		String dataStr = request.getParameter("data");
		String valorStr = request.getParameter("valor");
		String categoriaStr = request.getParameter("categoria");
		
		LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Double valor = Double.valueOf(valorStr);
		
		Despesas despesas = new Despesas(0, descricaoStr, data, valor, categoriaStr);
		
		// Modulo de persistencia
		
		// Exibir o conteúdo
		
		response.sendRedirect("index.html");
		
	}
}
