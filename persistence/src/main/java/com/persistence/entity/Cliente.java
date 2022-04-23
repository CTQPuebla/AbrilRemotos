package com.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//persistence

@Entity
@Table(name="CLIENTES")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
property="@clienteId", scope=Cliente.class)

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

	
	//Atributo relacional
	@OneToMany(mappedBy ="cliente", cascade =CascadeType.ALL)
	private List<Venta> venta;
	
	
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
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
