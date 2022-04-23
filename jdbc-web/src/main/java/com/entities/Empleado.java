package com.entities;

import java.sql.Date;

public class Empleado {

	
	//atributos
	private int empleadoId;
	private String nombre;
	private int antiguedad;
	private String sexo;
	private String estadoCivil;
	private Date fechaNac;
	private int cargoId;
	
	public Empleado() {
		
	}
	
	
	//Contructor con todos los parametros
	public Empleado(int empleadoId, String nombre, int antiguedad, String sexo, String estadoCivil, Date fechaNac,
			int cargoId) {
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.cargoId = cargoId;
	}


	public int getEmpleadoId() {
		return empleadoId;
	}


	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public int getCargoId() {
		return cargoId;
	}


	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}
	
}
