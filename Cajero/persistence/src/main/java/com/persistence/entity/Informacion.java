package com.persistence.entity;

public class Informacion {
	int cantidad;
	double denominacion;
	
	
	//Genero un constructor vacio para poder crear objetos del tipo informacion sinla necesidad de 
	//introducir los parametros de atributos y no necesito inizializar nada, solo crearlo
	public Informacion() {
						
		}
	
	public Informacion(int cantidad, double denominacion) {
		
		this.cantidad = cantidad;
		this.denominacion = denominacion;
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
