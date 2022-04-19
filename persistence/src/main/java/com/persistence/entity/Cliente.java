package com.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//persistence

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="c_id_auto")
	@SequenceGenerator(name="c_id_auto", sequenceName="CLIENTE_SEQ", allocationSize = 1)
	
	
	@Column(name="CLIENTE_ID", columnDefinition="NUMBER")
	int clienteId;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(15)")
	String nombre;
	
	@Column(name="TELEFONO", columnDefinition="NVARCHAR2(10)")
	String telefono;
	
	@Column(name="CORREO", columnDefinition="NVARCHAR2(15)")
	String correo;
	
	@Column(name="STATUS", columnDefinition="NUMBER")
	int status;

	
	
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
