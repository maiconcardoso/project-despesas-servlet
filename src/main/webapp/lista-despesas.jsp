<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

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


	<h2 style="padding-bottom: 10px; padding-top: 10px">Lista de Despesas</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Descrição</th>
				<th scope="col">Data</th>
				<th scope="col">Valor</th>
				<th scope="col">Categoria</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listaDespesas" items="despesa">
				<tr>
					<th scope="row">${despesa.getId()}</th>
					<td>${despesa.getDescricao()}</td>
					<td>${despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}</td>
					<td>${despesa.getValor()}</td>
					<td>${despesa.getCategoria()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>