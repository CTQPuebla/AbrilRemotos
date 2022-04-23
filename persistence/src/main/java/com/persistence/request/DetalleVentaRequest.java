package com.persistence.request;

import com.persistence.entity.Producto;
import com.persistence.entity.Venta;

public class DetalleVentaRequest {
	
	// Atributos
	private int dtvId;
	private Venta venta;
	private Producto producto;
	private int cantidad;
	
	public DetalleVentaRequest(int dtvId, Venta venta, Producto producto, int cantidad) {
		super();
		this.dtvId = dtvId;
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getDtvId() {
		return dtvId;
	}

	public void setDtvId(int dtvId) {
		this.dtvId = dtvId;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProductoId(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
