package com.persistence.request;


import java.time.LocalDate;

import com.persistence.entity.Producto;

public class InventarioRequest {
	
	int inventarioId;
	Producto producto;
	int stock;
	LocalDate fecha_res;
	
	
	public InventarioRequest(int id) {
		
		this.inventarioId = id;
		
	}


	public InventarioRequest(int inventarioId, Producto producto, int stock, LocalDate fecha_res) {
		
		this.inventarioId = inventarioId;
		this.producto = producto;
		this.stock = stock;
		this.fecha_res = fecha_res;
	}


	public int getInventarioId() {
		return inventarioId;
	}


	public void setInventarioId(int inventarioId) {
		this.inventarioId = inventarioId;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public LocalDate getFecha_res() {
		return fecha_res;
	}


	public void setFecha_res(LocalDate fecha_res) {
		this.fecha_res = fecha_res;
	}
	
	
	
	

}
