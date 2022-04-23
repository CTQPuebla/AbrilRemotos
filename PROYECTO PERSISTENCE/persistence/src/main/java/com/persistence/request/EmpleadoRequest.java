package com.persistence.request;

import java.time.LocalDate;

public class EmpleadoRequest {
	
	// Atributos
	private int empleadoId;
	private String nombre;
	private int antiguedad;
	private String sexo;
	private String estadoCivil;
	private LocalDate fechaNac;
	private int cargoId;
	private int status;
	
	public EmpleadoRequest(int id) {}

	public EmpleadoRequest(int empleadoId, String nombre, int antiguedad, String sexo, String estadoCivil,
			LocalDate fechaNac, int cargoId, int status) {
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.cargoId = cargoId;
		this.status = status;
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
