package com.despesas.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
