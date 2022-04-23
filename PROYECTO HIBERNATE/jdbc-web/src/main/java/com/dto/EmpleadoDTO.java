package com.dto;

public class EmpleadoDTO {
	
	private String nombre;
	private int antiguedad;
	private String descripcion;
	
	public EmpleadoDTO() {}

	public EmpleadoDTO(String nombre, int antiguedad, String descripcion) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
