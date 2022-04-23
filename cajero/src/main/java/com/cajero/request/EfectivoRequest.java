package com.cajero.request;

public class EfectivoRequest {

	// Atributos
	private int id;
	private String tipo;
	private double denominacion;
	private int existencia;

	public EfectivoRequest() {
	}

	public EfectivoRequest(int id) {
		this.id = id;
	}

	public EfectivoRequest(int id, String tipo, int denominacion, int existencia) {
		this.id = id;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.existencia = existencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

}
