package com.persistence.request;

public class ClienteRequest {

	// Atributos
	private int clienteId;
	private String nombre;
	private String telefono;
	private String correo;
	private int status;

	public ClienteRequest(int id) {
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
