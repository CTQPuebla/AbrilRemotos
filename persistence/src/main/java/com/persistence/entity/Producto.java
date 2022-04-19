package com.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//persistence

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="p_id_auto")
	@SequenceGenerator(name="p_id_auto", sequenceName="PRODUCTOS_SEQ", allocationSize = 1, initialValue=1)
	
	
	@Column(name="PRODUCTO_ID", columnDefinition="NUMBER")
	int productoId;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(20)")
	String nombre;
	
	@Column(name="PRESENTACION", columnDefinition="NVARCHAR2(20)")
	String presentacion;
	
	@Column(name="PRECIO", columnDefinition="NUMBER")
	int precio;
	
	@Column(name="FECHA_CAD", columnDefinition="DATE")
	Date fechaCad;
	
	@Column(name="MARCA", columnDefinition="NVARCHAR2(15)")
	String marca;
	
	@Column(name="STATUS", columnDefinition="NUMBER")
	int status;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
