<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.despesas.dao.DespesasDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.despesas.model.Despesas"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous">
</script>
<title>Lista de Despesas</title>
</head>
<body>

	<%
		DespesasDao despesasDao = new DespesasDao();
		List<Despesas> listaDespesas = despesasDao.readAll();
	%>

	<h2 style="padding-bottom: 10px; padding-top: 10px">Lista de Despesas</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Descrição</th>
				<th scope="col">Data</th>
				<th scope="col">Valor</th>
				<th scope="col">Categoria</th>
				<th scope="col">Funções</th>
			</tr>
		</thead>
		<tbody>
			<% for(Despesas despesas : listaDespesas) { 
			%>
			<tr>
				<th scope="row"><%=despesas.getId() %> </th>
				<td><%=despesas.getDescricao()%></td>
				<td><%=despesas.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
				<td><%=despesas.getValor()%></td>
				<td><%=despesas.getCategoria()%></td>
				<td> 
					<a href="controladora?action=RemoveDespesas&id=<%=despesas.getId()%>"> 
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  								<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5M8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5m3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0"/>
						</svg>
					</a> 
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>