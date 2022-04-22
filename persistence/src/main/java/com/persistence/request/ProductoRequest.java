package com.persistence.request;


import java.time.LocalDate;

public class ProductoRequest {
	
	int productoId;
	String nombre;
	String presentacion;
	int precio;
	LocalDate fechaCad;
	String marca;
	int status;
	
	
public ProductoRequest(int id) {
		
		this.productoId = id;
	}


public ProductoRequest(int productoId, String nombre, String presentacion, int precio, LocalDate fechaCad, String marca,
		int status) {
	
	this.productoId = productoId;
	this.nombre = nombre;
	this.presentacion = presentacion;
	this.precio = precio;
	this.fechaCad = fechaCad;
	this.marca = marca;
	this.status = status;
}


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


public LocalDate getFechaCad() {
	return fechaCad;
}


public void setFechaCad(LocalDate fechaCad) {
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
