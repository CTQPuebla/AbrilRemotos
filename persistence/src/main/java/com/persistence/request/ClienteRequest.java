package com.persistence.request;



public class ClienteRequest {
	
	int clienteId;
	String nombre;
	String telefono;
	String correo;
	int status;
	
	
public ClienteRequest(int id) {
		
		this.clienteId = id;
	}


public ClienteRequest(int clienteId, String nombre, String telefono, String correo, int status) {
	
	this.clienteId = clienteId;
	this.nombre = nombre;
	this.telefono = telefono;
	this.correo = correo;
	this.status = status;
}



public int getClienteId() {
	return clienteId;
}


public void setClienteId(int clienteId) {
	this.clienteId = clienteId;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getTelefono() {
	return telefono;
}


public void setTelefono(String telefono) {
	this.telefono = telefono;
}


public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}


public int getStatus() {
	return status;
}


public void setStatus(int status) {
	this.status = status;
}


}
