package com.entities;

public class Cargo {

	
	//atributos
	private int cargoId;
	private String descripcion;
	private int sueldo;
	
	public Cargo() {
		
	}
	
	//Contructor con todos los parametros
	public Cargo(int cargoId, String descripcion, int sueldo) {
		this.cargoId = cargoId;
		this.descripcion = descripcion;
		this.sueldo = sueldo;
	}
//Getters & Setters

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
}
