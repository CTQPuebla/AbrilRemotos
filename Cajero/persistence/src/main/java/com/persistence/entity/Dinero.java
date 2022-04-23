package com.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DINERO")
public class Dinero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="DINERO_ID", columnDefinition="NUMBER")
	int dineroId;
	
	@Column(name="TIPO", columnDefinition="NVARCHAR2(20)")
	String tipo;
	
	@Column(name="CANTIDAD", columnDefinition="NUMBER")
	int cantidad;
	
	@Column(name="DENOMINACION", columnDefinition="NUMBER")
	double denominacion;
	
	

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
