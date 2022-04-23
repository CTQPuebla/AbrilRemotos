package com.persistence.request;

import java.time.LocalDate;

import com.persistence.entity.Producto;

public class InventarioRequest {
	
	// Atributos
	private int inventarioId;
	private Producto producto;
	private int stock;
	private LocalDate fechaResurtido;
	
	public InventarioRequest(int id) {}

	public InventarioRequest(int inventarioId, Producto producto, int stock, LocalDate fechaResurtido) {
		super();
		this.inventarioId = inventarioId;
		this.producto = producto;
		this.stock = stock;
		this.fechaResurtido = fechaResurtido;
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

	public LocalDate getFechaResurtido() {
		return fechaResurtido;
	}

	public void setFechaResurtido(LocalDate fechaResurtido) {
		this.fechaResurtido = fechaResurtido;
	}
	
}
