package com.persistence.request;

public class DineroRequest {
	
	int dineroId;
	String tipo;
	int cantidad;
	double denominacion;
	
	public DineroRequest(int id) {
			
			this.dineroId = id;
		}

	public DineroRequest(int dineroId, String tipo, int cantidad, double denominacion) {
		
		this.dineroId = dineroId;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.denominacion = denominacion;
	}

	
	public int getDineroId() {
		return dineroId;
	}

	public void setDineroId(int dineroId) {
		this.dineroId = dineroId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(double denominacion) {
		this.denominacion = denominacion;
	}

	
	
	
	
}
