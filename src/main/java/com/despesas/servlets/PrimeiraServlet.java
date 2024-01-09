package com.despesas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet no linux</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Primeira Servlet Rodando no linux!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
       
}
