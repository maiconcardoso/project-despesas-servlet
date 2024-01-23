package com.despesas.actions;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.dao.DespesasDao;
import com.despesas.model.Despesas;

public class AdicionaDespesa implements Action{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String descricaoStr = request.getParameter("descricao");
		String dataStr = request.getParameter("data");
		String valorStr = request.getParameter("valor");
		String categoriaStr = request.getParameter("categoria");
		
		LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Double valor = Double.valueOf(valorStr);
		
		Despesas despesas = new Despesas(descricaoStr, data, valor, categoriaStr);
		
		//   Modulo de persistencia 
		DespesasDao dao = new DespesasDao(); 
			try {
				dao.create(despesas); 
			} catch (SQLException e) 
				{ e.printStackTrace(); 
			} catch (ClassNotFoundException e) 
				{ e.printStackTrace(); 
			}
		
		return "/despesa-adicionado.jsp";
	}

}
