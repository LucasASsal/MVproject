package com.api.entity;


public class CategoryEntity{
	int cdCategoria;
	String dsCategoria;
	int nrPercentual;
	public int getCdCategoria() {
		return cdCategoria;
	}
	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}
	public String getDsCategoria() {
		return dsCategoria;
	}
	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
	public int getNrPercentual() {
		return nrPercentual;
	}
	public void setNrPercentual(int nrPercentual) {
		this.nrPercentual = nrPercentual;
	}
	public CategoryEntity(int cdCategoria, String dsCategoria, int nrPercentual) {
		super();
		this.cdCategoria = cdCategoria;
		this.dsCategoria = dsCategoria;
		this.nrPercentual = nrPercentual;
	}

}
