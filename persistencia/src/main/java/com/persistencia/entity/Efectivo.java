package com.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "EFECTIVO")
public class Efectivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EFECTIVO_ID", columnDefinition = "NUMBER")
	private int efectivoId;
	
	@Column(name ="TIPO", columnDefinition ="NVARCHAR2(15)")
	private String tipo; 
	
	@Column(name = "DENOMINACION", columnDefinition="NUMBER(8,2)")
	private double denominacion;
	
	@Column(name = "CANTIDAD", columnDefinition="NUMBER")
	private int cantidad;

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
