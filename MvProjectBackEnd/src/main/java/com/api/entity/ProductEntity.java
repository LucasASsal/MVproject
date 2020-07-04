package com.api.entity;

public class ProductEntity {
	private int codigo;
	private String descricao;
	private int preco;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public ProductEntity(int codigo, String descricao, int preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}
	
}
