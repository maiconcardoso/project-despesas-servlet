package com.despesas.model;

import java.io.NotSerializableException;
import java.time.LocalDate;

public class Despesas extends NotSerializableException{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	private LocalDate data;
	private double valor;
	private String categoria;
	
	public Despesas() {
		super();
	}
	public Despesas(int id, String descricao, LocalDate data, double valor, String categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
