package com.despesas.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despesas.actions.Action;



@WebServlet("/controladora")
public class ControladoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	   
	   try {
		   String actionName = request.getParameter("action");
		   System.out.println("Ação executada : " + actionName);
		   String pacote = "com.despesas.actions.";
		   
		   Class classe = Class.forName(pacote + actionName);
		   Action action = (Action) classe.newInstance();
		   String result = action.executa(request, response);
		   
		   RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		   dispatcher.forward(request, response);
		   
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	}
   }

}
