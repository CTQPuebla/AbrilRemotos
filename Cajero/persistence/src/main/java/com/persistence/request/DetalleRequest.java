package com.persistence.request;

import com.persistence.entity.Retiro;

public class DetalleRequest {
	
	int dtrId;
	Retiro retiro;
	String tipo;
	int cantidad;
	double denominacion;
	
	public DetalleRequest() {
		}
	
	public DetalleRequest(int id) {
		
		this.dtrId = id;
	}


	public DetalleRequest(int dtrId, Retiro retiro, String tipo, int cantidad, double denominacion) {
		
		this.dtrId = dtrId;
		this.retiro = retiro;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.denominacion = denominacion;
	}


	public int getDtrId() {
		return dtrId;
	}


	public void setDtrId(int dtrId) {
		this.dtrId = dtrId;
	}


	public Retiro getRetiro() {
		return retiro;
	}


	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
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
