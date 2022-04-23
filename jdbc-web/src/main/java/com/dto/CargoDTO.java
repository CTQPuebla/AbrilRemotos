package com.dto;

import java.util.List;

import com.entities.Empleado;

public class CargoDTO {
	
	private String descripcion;
	private List<Empleado>list;
	
	public CargoDTO() {}
	
	public CargoDTO(String descripcion, List<Empleado> list) {
		this.descripcion = descripcion;
		this.list = list;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getList() {
		return list;
	}

	public void setList(List<Empleado> list) {
		this.list = list;
	}

	//@Override
	//public String toString() {
		//return "CargoDTO [descripcion=" + descripcion + ", list=" + list + "]";
	//}
	

}
