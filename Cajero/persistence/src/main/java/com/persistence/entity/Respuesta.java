package com.persistence.entity;

import java.util.List;

public class Respuesta {
	
	
	String mensaje;
	List<Informacion> info;
	
	
	public Respuesta() {
	}
	
	public Respuesta(double solicitud) {
	}

	public Respuesta(List<Informacion> info) {
			this.info = info;
		}

	public Respuesta(String mensaje, List<Informacion> info) {
		
		this.mensaje = mensaje;
		this.info = info;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public List<Informacion> getInfo() {
		return info;
	}


	public void setInfo(List<Informacion> info) {
		this.info = info;
	}
	
	
	

}
