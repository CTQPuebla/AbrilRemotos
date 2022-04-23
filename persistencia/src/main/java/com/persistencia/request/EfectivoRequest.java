package com.persistencia.request;

public class EfectivoRequest {

	private int efectivoId;
	private String tipo;
	private double denominacion;
	private int cantidad;
	
	
	
	public EfectivoRequest(int efectivoId, String tipo, double denominacion, int cantidad) {
		
		this.efectivoId = efectivoId;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}
	
	

	public EfectivoRequest(int efectivoId, int cantidad) {
		
		this.efectivoId = efectivoId;
		this.cantidad = cantidad;
	}



	public int getEfectivoId() {
		return efectivoId;
	}



	public void setEfectivoId(int efectivoId) {
		this.efectivoId = efectivoId;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public double getDenominacion() {
		return denominacion;
	}



	public void setDenominacion(double denominacion) {
		this.denominacion = denominacion;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
}
